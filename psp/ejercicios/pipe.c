#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main ()
{
int fd[2];
char buffer[30];
pid_t pid;

pipe(fd);

pid=fork();

switch(pid)
{
case -1:
printf("no se ha podido crear el hijo\n");
exit(-1);
break;

case 0:
printf("el hijo escribe en el pipe...\n");
//write(fd[1],"Hola Papi",10);
break;

default:
// wait(NULL);
printf("el padre lee del pipe..\n");
read (fd[0],buffer,10);
printf("\tMensaje leido:%s\n",buffer);
break;
}
}
