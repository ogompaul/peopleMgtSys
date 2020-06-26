#include<stdio.h>
#include<stdlib.h>
//#include<unistd>
#include<errno.h>
#include<sys/types.h>
#include<string.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<sys/msg.h>

#define TEXT_SIZE 512

struct msg_Object{
  long int txtDataType;
  char msgContent[TEXT_SIZE];
};

//Sender program
int main()
{
 int running = 1;
 struct msg_Object message;
 int msgid;
 char msgQueue[BUFSIZ];
 //key_t key;
 
 msgid = msgget((key_t) 1234, 0666 | IPC_CREAT);
 
 if(msgid == -1)
 {
   fprintf(stderr, "mssgget failed with error: %d\n", errno);
   exit(EXIT_FAILURE);
 }
 
 /*Course details*/
 printf("----------------------------------------\n 	-----------------------------------------	\n Name: Message Queue\n Authors: Patrick Chimeudeonwo\n          Hazo\n Version: Lab3.2.a\n Descripttion: This program send a text to a queue ans wait for it to be read\n");
 
 while(running)
 {
   printf("\nEnter some text: ");
   fgets(msgQueue, BUFSIZ, stdin);
   message.txtDataType = 1;
   strcpy(message.msgContent, msgQueue);
   
   if(msgsnd(msgid, (void *)&message, TEXT_SIZE, 0) == -1)
   {
     fprintf(stderr, "msgsend failed\n");
     exit(EXIT_FAILURE);
   }
   if(strncmp(msgQueue, "end", 3) == 0)
   {
     running = 0;
   }
 }
 exit(EXIT_SUCCESS);
}


