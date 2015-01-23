#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main ()
{
int fd[2];
pid_t pid;
char saludoPadre[]="buenos dias hijo.\0";
char buffer[80];


pipe(fd);
pid=fork();

switch(pid)
{
case -1:
printf("no se ha podido crear el hijo");
exit(-1);

case 0:
close (fd[1]);
read(fd[0],buffer, sizeof(buffer));
printf("\el hijo recibe algo del pipe.%s\n",buffer);
//write(fd[1],"Hola Papi",10);
break;

default:
// wait(NULL);
close (fd[0]);
write(fd[1],saludoPadre, strlen(saludoPadre));
printf("El hijo envia mensaje al hijo %s\n",buffer);
wait(NULL);
//read (fd[0],buffer,10);
//printf("\tMensaje leido:%s\n",buffer);
break;
}
return 0;
}
