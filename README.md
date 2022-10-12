# Encurtador de URL

Encurtador de URL, criado com Java e Spring Boot. Esse serviço possibilita que um usuário passe a URL a ser encurtada, recebendo um uma *urlId* que, ao ser acessada pela rota raíz, é redirecionado para a URL original.

## Como Instalar

Para instalar pelo terminal utilize o Maven para fazer a build:

```
$ mvn clean install
```

### Como Utilizar

Rode o programa e acesse os endpoits pela rota raíz `http://.../{identificador}`. Fui utilizado a plataforma Postman para acessar os endpoints.

Criar url encurtada:
```
POST /{url-original}
```

Acessar com URL encurtada
```
GET /{urlId-gerado}
```

Remover URL
```
DELETE /{urlId-gerado}
```

### Tecnologias utilizadas

- Java 11
- Sping Boot
- Maven
- H2