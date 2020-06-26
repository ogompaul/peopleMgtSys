#include <stdio.h>
 #include <unistd.h>
 #include <signal.h>
 #include <string.h>
 #include <stdlib.h>
 #include<fcntl.h>
 #define FALSE 0
 #define TRUE (!FALSE)
 #define DATA_SIZE 1000
 
 volatile sig_atomic_t flag = FALSE;

 void my_handler(int);
 void sigh(int);
 
 void displayFile(char *input, FILE *file_txt);
 
void flagDisplay(char *input, FILE *file, int argc);
  
 int main(int argc, char *argv[1])
 {
 
  printf("------------------------------------------------\n------------------------------------------------ \n OS Lab3 Task 3.1\n By: Patrick Chimeudeonwo  \n     Hazlet Mwangi Gathigia \n ------------------------------------------------\n------------------------------------------------ \n \n");
 
  sigset_t set;
  struct sigaction act;
  sigemptyset(&set);
  sigaddset(&set, SIGINT);
  //sigaddset(&set, SIGUSR1);
  act.sa_flags = 0;
  act.sa_mask = set;
  act.sa_handler = &my_handler;
  //sigaction(SIGUSR1, &act, NULL); 
  sigaction(SIGINT, &act, NULL);  
  
  /*Read the argv file and output the content*/
  char *in_file;
  in_file = argv[argc - 1];
  FILE *input_file = fopen(in_file, "r");  
  
  printf("File content: \n");
  displayFile(in_file, input_file);
  //fclose(input_file);  

 
 while(!flag)
 {
   sleep(2);   
   
   signal(SIGUSR1, sigh);
   printf("flag: %d\n", flag);  
       
   if(flag)
     {
      printf("triggered file content: \n");
      flagDisplay(in_file, input_file, argc);      
     } 
    if(!flag)
    {
     printf("Press ctr C to trigger\n"); 
     printf("Not triggered\n\n");
    }
 }
  return 0;
}

void my_handler(int signum)
{
  //if(signum == SIGINT) 
     flag = TRUE;
}

void sigh(int sig_num)
{
  flag = TRUE;
}

void displayFile(char *input, FILE *file_txt)
{
int i = sizeof(input)/sizeof(input[0]);
  while(fgets(input, sizeof(input)+1/*DATA_SIZE*/, file_txt) != NULL){
    printf("%s", input); 
    //printf("size of input: %d, input: %s\n", i, input);    
  }
  
}

void flagDisplay(char *input, FILE *file, int argc)
{
   char *extra = "concatinate this text to the file contented when  triggered";
   printf("file content read on trigger: %s\n", input); 
   const int len = sizeof(input)/sizeof(input[0]) + 1000;
   int k = 0, i = sizeof(input)/sizeof(input[0]);
   char *newBuf = (char *) malloc(len);
   strcpy(newBuf, input);   
   strcat(newBuf, extra); 
   strcpy(input, newBuf);     
     
   printf("file content input plus string concatenated: %s\n", input);
   free(newBuf);
}
 
