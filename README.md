# E-commerce 
O sistema permite criar clientes, caddastrar produtos e realizar a compra de produtos
### 1. Produtos:
- GET /product → Retorna a lista de todos os produtos cadastrados.

- POST /product → Cadastra um novo produto.
``` json
{
    "name": "papel"
    "price": 5,
    "quantity": 2
}
```
- DELETE /product/{name} → Deleta um produto \
exemplo: http://localhost:8080/product/papel

### 2. Clientes:
- POST /client → Cadastra um novo cliente.
```json
{
    "name": "matheus",
    "cpf": "22613900091",
    "email": "matheus@zup.com"
}
```
- GET /client/{cpf} → Retorna os dados de um cliente específico pelo CPF. \
  exemplo: http://localhost:8080/client/22613900091
- PUT /client/{cpf} → Atualiza dados de um cliente. \
  exemplo: http://localhost:8080/client/22613900091

### 3. Compras:
POST /buy → Registra uma nova compra atualizando quantidade de produto.
``` json
{
    "cpf": "22613900091",
    "products": [
        {"name": "papel"}
    ]
}
```
