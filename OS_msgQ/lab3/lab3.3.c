#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<signal.h>
#include<errno.h>
#include<sys/shm.h>
#include<string.h>
#include <sys/ipc.h>
#include <sys/wait.h>
#include <sys/types.h>

#define FALSE 0
#define TRUE 1
#define TEXT_SZ 2048

/*prototype*/
char *invertptr(char *text);

volatile sig_atomic_t flag = FALSE;

struct shared_mem
{
  int data;
  char msg[TEXT_SZ];
};

void sigh(int);

int main()
{
  pid_t npid;
  int status;
  struct shared_mem *sharedMemory;
  char msgbuf[BUFSIZ];
  
  int shmid = shmget((key_t) 1237, sizeof(sharedMemory->data), 0666 | IPC_CREAT);
  //sharedMemory = (char*) shmat(shmid, 0, 0);
  //sharedMemory = (struct shared_mem *) shmat(shmid, 0, 0);
  //memset(sharedMemory->msg, 0, sizeof(sharedMemory->msg));
  npid = fork();
 
 while(1)
{ 
  
  if(npid)
    {   
    sharedMemory = (struct shared_mem *) shmat(shmid, 0, 0);
    if(shmid == -1) //(shmid < 0)
     {
      fprintf(stderr, "shmget failed with error no: %d\n", errno);
      exit(EXIT_FAILURE);
      //return EXIT FAILURE
     }  
  
  printf("P1 Memory Attached at %p\n", &sharedMemory->data);
  printf("P1: enter a message for PID: %d\n", getpid());
  
  //Reads the input and stores it in char array msg[] of the shared memory
  fgets(sharedMemory->msg, BUFSIZ, stdin);
  
  //copy from shm to msgbuf
  strncpy(msgbuf, sharedMemory->msg, TEXT_SZ);  
  
  printf("\nmsg in shm from P1: %s", sharedMemory->msg);
  
  //on failure, shmat()  return -1  //if sharedmemory was not successfully created return error
   //if(sharedMemory == (void *) -1)
   if(sharedMemory == (struct shared_mem *) -1)
   {
    fprintf(stderr, "Shmat failed\n");
    exit(EXIT_FAILURE);
   } 
 
 /*if p1 is still attached to shm return error else 
 release the sharedmemory*/
  if(shmdt(sharedMemory) == -1)  
  {
     fprintf(stderr, "\nparent p: shmdt failed\n");
     exit(EXIT_FAILURE);
  }
   
     kill(npid, SIGUSR1); //send signal to child process
     printf("Parent p: SIGUSR1 has been sent.%d\n", getpid());
     //wait(&status);
    if(flag){ 
      printf("P1 msg from p2 %s\n", sharedMemory->msg);   	
   }
    //printf("Parent process: child p terminated, exit state = %i\n", WEXITSTATUS(status));
     //status = 0;
     sleep(1);
     //return 0;
    }


  //else: child process execute
    //printf("child process waiting ...%d\n", getpid());
    signal(SIGUSR1, sigh);
    pause();
    sharedMemory = (struct shared_mem *) shmat(shmid, 0, 0);
      
   //on failure, shmat()  return -1
   //if(sharedMemory == (void *) -1)
   if(sharedMemory == (struct shared_mem *) -1)
   {
    fprintf(stderr, "Shmat failed\n");
    exit(EXIT_FAILURE);
   }
   
   /*print address of child process*/
   printf("\nP2 Memory Attached at %p\n", &sharedMemory->data);
  
  //read and invert data and send it back to the shared memory i.e data
   printf("p2 PID: %d, rcvd this msg from shm: %s", getpid(), sharedMemory->msg);
   printf("\n");
   char *inverted = invertptr(sharedMemory->msg);
   printf("inverted: %s\n", inverted);
   strncpy(msgbuf, inverted, TEXT_SZ);
   strncpy(sharedMemory->msg, inverted, TEXT_SZ);
   sleep(1);
   printf("p2 inverted in shm: %s", sharedMemory->msg);
   
   //release the sharedmemory
   if(shmdt(sharedMemory) == -1)  
  {
     fprintf(stderr, "\nchild p: shmdt failed\n");
     exit(EXIT_FAILURE);
  }
   //status = 55;
   //return 55;
   kill(npid, SIGUSR1);
   //printf("\nP2 Memory released\n");
} //end of while loop

}



char *invertptr(char *text)
 {
   char *inverted = (char *) malloc(sizeof(char));
  int k = 0, s = strlen(text); 
  while(text[k] != '\0'){
    inverted[k] = text[s - 1];
    k++;
    s--;
  }
  return inverted;
 }

void sigh(int signum){
  flag = TRUE;
}
