# Consignado
- Esta aplicação tem por finalidade simular a averbação de emprestimo consignado, com desconto pelo inss.
- Exitem dois fluxos existentes, legado e uma api rest, ambos com suas restrições.
- Para convivência dos dois fluxos, utilizamos o ff4j como liga e desliga (em relação ao legado)
- Abaixo encontra-se a arquitetura utilizada do contexto.

![alt text](https://github.com/fabriciolfj/averbacao-service/blob/main/averba%C3%A7%C3%A3o.drawio.png)
- Utilizou-se arquitetura clean para disponisção dos pacotes da aplicação.
  ![alt text](https://github.com/fabriciolfj/averbacao-service/blob/main/clean.png)
### Ambiente
- Existe o docker-compose na aplicação, afim de simular dependências do mesmo, para subida local.
- Abaixo o endpoint do ffj4 e swagger.
```
http://localhost:8181/ff4j-web-console/features
http://localhost:8181/swagger-ui.html
```
