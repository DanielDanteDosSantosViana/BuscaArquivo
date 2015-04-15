#include <stdio.h>
#include <string.h>
#include <stdlib.h>
 
typedef struct {
 
    char endereco[73];
    char bairro[73];
    char cidade[73];
    char nomeEstado[73];
    char siglaEstado[3];
    char cep[9];
 
} Endereco;
 
int main(int argc, char** argv)
{
    FILE *entrada, *saida;
    Endereco e;
    int achei;
    long registro;
    long fim;
    long meio;
    long inicio;

    if(argc != 2)
    {
        fprintf(stderr,"Erro na chamada do comando.\n");
        fprintf(stderr,"Uso: %s [CEP].\n", argv[0]);
        return 1;
    }
 
    printf("Procurando o CEP [%s]\n",argv[1]);
 
    entrada = fopen("/home/daniel/Downloads/Aula3/cep_ordenado.dat","r");
    if(!entrada)
    {
        fprintf(stderr,"Arquivo %s não pode ser aberto para leitura\n", "cep.dat");
        return 1;
    }
 
    registro = 0;
 
    //fseek(entrada,390560L*300,SEEK_SET);
    
    memset(&e,0,sizeof(Endereco));
    fread(&e.endereco,1,72,entrada);
    fread(&e.bairro,1,72,entrada);
    fread(&e.cidade,1,72,entrada);
    fread(&e.nomeEstado,1,72,entrada);
    fread(&e.siglaEstado,1,2,entrada);
    fread(&e.cep,1,8,entrada);
    
    inicio = 0;
    fim = ftell(entrada)*300;
    meio = (inicio + fim)/2;
    
    fseek(entrada,meio*300,SEEK_SET);
    printf("%lu\n Valor do fim : ",fim);
        
    while(inicio <= fim)
    {
        printf("%lu\n registro : ",registro);
        printf("%s\n cep inicio : ",e.cep);


        if(strcmp(e.cep,argv[1]) == 0)
        {
            printf("\n");
            printf("Nº Registro..: %ld\n",registro);
            printf("Endereco.....: %s\n",e.endereco);
            printf("Bairro.......: %s\n",e.bairro);
            printf("Cidade.......: %s\n",e.cidade);
            printf("Nome Estado..: %s\n",e.nomeEstado);
            printf("Sigla Estado.: %s\n",e.siglaEstado);
            printf("CEP..........: %s\n",e.cep);
            break;
        }

        char x [10] ="123";
        int teste =  atol(x);
        long valorCepBuscado = atol(argv[1]);
        long valorCepEncontrado =  atol(e.cep);

        printf("%d\n valor x : ",teste);
    
    
        if(valorCepBuscado > valorCepEncontrado)
            inicio = meio +1 ;
        else
            fim = meio -1;
       

       memset(&e,0,sizeof(Endereco));
       fread(&e.endereco,1,72,entrada);
       fread(&e.bairro,1,72,entrada);
       fread(&e.cidade,1,72,entrada);
       fread(&e.nomeEstado,1,72,entrada);
       fread(&e.siglaEstado,1,2,entrada);
       fread(&e.cep,1,8,entrada);
       
       meio = (inicio + fim)/2;
       fseek(entrada,meio*300,SEEK_SET);        
       registro++;

        
    }
 
    fclose(entrada);
}