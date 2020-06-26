#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<errno.h>
#include<sys/types.h>
#include<string.h>
#include<signal.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<sys/msg.h>

#define TEXT_SIZE 512

struct msg_Object{
  long int txtDataType;
  char msgContent[TEXT_SIZE];
};

void time_out(int);

//Sender program
int main()
{
 /*Course details*/
 printf("----------------------------------------\n 	-----------------------------------------	\n Name: Message Queue\n Authors: Patrick Chimeudeonwo\n          Hazlet Mwangi\n Version: Lab3.2.b\n Description: This program reads a text from the queue and dispays the content\n");

 int running = 1;
 struct msg_Object message;
 int msgid;
 char msgQueue[TEXT_SIZE];
 long int msgToRcv = 0;
 
 /*First, we set up the message queue.*/ 
 msgid = msgget((key_t) 1234, 0666 | IPC_CREAT);
 
 if(msgid == -1)
 {
   fprintf(stderr, "mssgget failed with error: %d\n", errno);
   exit(EXIT_FAILURE);
 }
 
 /*Then the message are retrieved from the queue, until an end message is ecountered. Lastly, the message queue is deleted*/
 int c = 0, val = msgrcv(msgid, (void *)&message, TEXT_SIZE, msgToRcv, 0);
 while(running)
 {
  if(msgrcv(msgid, (void *)&message, TEXT_SIZE, msgToRcv, 0) == -1)
   {
     fprintf(stderr, "msgsend failed with error: %d\n", errno);
     exit(EXIT_FAILURE);
   }  
   strncpy(msgQueue, message.msgContent, sizeof(msgQueue));
   //for(int i = 0; i < 100; i++){
   
    /*3.2.a: sleep 1 second and check the msq queue again for a new msg*/
   while(message.msgContent[0] != '\0'){
    if(message.msgContent != msgQueue) { 
     printf("\nYour wrote: %s", message.msgContent); 
     memset(message.msgContent, 0, sizeof(message.msgContent));  
     sleep(1); //Wait 1 sec and check while loop condition (queue) again
    }   
   }
   
   while((c  = (message.msgContent[0] == '\0')) == 1){
    printf("\nNo message to read ...\n"); 
    sleep(1); //wait 1 sec and check the queue again 
    if(c == 1)
    	break;      
   }
   
   /*timeout*/
   if(signal(SIGUSR1, time_out))
   {
    printf("TIMEDOUT\n");
     running = 0;     
   }
   
      
   if(strncmp(msgQueue, "end", 3) == 0)
   {
     running = 0;
   }
   if(sleep(1))
      kill(1, SIGUSR1);
 }
 
   exit(EXIT_SUCCESS);
}

void time_out(int signum)
{
   
}

