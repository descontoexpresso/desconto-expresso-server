
# Desconto Expresso

E-commerce social baseado na ODS 1 - Erradicação da Pobreza Extrema. No qual, esta em desenvolvimento um aplicativo em que pessoas de baixa renda envolvidos em programas do governo (Cadastro Único) tem acesso a alimentos básicos por um preço mais acessível. Além do software de ecommerce, o projeto também se deve através de parcerias com mercados regionais patrocinando e fazendo doações de alimentos perto da validade que normalmente seriam descartados.

## 👾 Atributos do Projeto

**Tabela 1 - tb_categorias**
 
<div align="center">

| Atributo   | Descrição e motivo da escolha       | Chave       |
| :---------- | :--------- | :---------------------------------- |
| id  | Identificador único da tabela categoria | **PK** |
| nomeCategoria | Nome da categoria | **NN** |
| descricaoCategoria | Descrição do uma categoria de produtos | **NN** |
| listaDeProdutos | Lista de produtos da categoria | **FK** |

</div>

**Tabela 2 - tb_produtos**
 
<div align="center">

| Atributo   | Descrição e motivo da escolha       | Chave       |
| :---------- | :--------- | :---------------------------------- |
| id  | Identificador único da tabela produto | **PK** |
| nomeProduto | Nome do produto | **NN** |
| descricaoProduto | Descrição do produto | **NN** |
| estoque | Quantidade de produtos disponíveis | **NN** |
| preco | Valor unitário do produto | **NN** |
| dataValidade | Data de validade do produto | **NN** |
| fotoProduto | Imagem do produto | **NN** |
| categoria | Chave estrangeira de tb_categorias | **FK** |
| usuario | Chave estrangeira de tb_usuario | **FK** |

</div>

**Tabela 3 - tb_usuario**
 
<div align="center">

| Atributo   | Descrição e motivo da escolha       | Chave       |
| :---------- | :--------- | :---------------------------------- |
| id | Identificador único da tabela usuário | **PK** |
| nomeUsuario | Nome do usuário | **NN** |
| sobrenomeUsuario | Sobrenome do usuário | **NN** |
| cadastroUnico | Número do cadastro único do usuário | **NN** |
| sobrenomeUsuario | Sobrenome do usuário | **NN** |
| dataNascimento | Data de nascimento do usuário | **NN** |
| telefone | Número de telefone do usuário | **NN** |
| cidade | Cidade em que o usuário reside | **NN** |
| bairro | Bairro da residência | **NN** |
| cep | CEP da residência | **NN** |
| rua | Rua da residência | **NN** |
| numeroCasa | Número da casa - complemento | **NN** |
| emailUsuario | E-mail de cadastro do usuário | **NN** |
| fotoUsuario | Foto do usuário | **NN** |
| senhaUsuario | Senha de cadastro do usuário | **NN** |
| listaDeProdutos | Lista de produtos da categoria | **FK** |

</div>


## 📚 Funcionalidades
### CategoriaController
- **Listar Categorias**: `GET /categorias` para listar todas as categorias. *(Requer token)*
- **Buscar por ID**: `GET /categorias/{id}` para obter uma categoria por ID. *(Requer token)*
- **Buscar por Nome**: `GET /categorias/categoria/{nome}` para buscar categorias pelo nome. *(Requer token)*
- **Criar Categoria**: `POST /categorias` para criar uma nova categoria. *(Requer token)*
- **Atualizar Categoria**: `PUT /categorias` para atualizar uma categoria existente. *(Requer token)*
- **Excluir Categoria**: `DELETE /categorias/{id}` para excluir uma categoria por ID. *(Requer token)*

### ProdutoController
- **Listar Produtos**: `GET /produtos` para listar todos os produtos.
- **Buscar por ID**: `GET /produtos/{id}` para obter um produto por ID. *(Requer token)*
- **Buscar por Nome**: `GET /produtos/produto/{nomeProduto}` para buscar produtos pelo nome. *(Requer token)*
- **Criar Produto**: `POST /produtos` para criar um novo produto.
- **Atualizar Produto**: `PUT /produtos` para atualizar um produto existente. *(Requer token)*
- **Excluir Produto**: `DELETE /produtos/{id}` para excluir um produto por ID. *(Requer token)*

### UsuarioController
- **Listar Usuários**: `GET /usuarios/all` para listar todos os usuários. *(Requer token)*
- **Buscar por ID**: `GET /usuarios/{id}` para obter um usuário por ID. *(Requer token)*
- **Autenticar Usuário**: `POST /usuarios/logar` para autenticar um usuário.
- **Registrar Usuário**: `POST /usuarios/cadastrar` para registrar um novo usuário.
- **Atualizar Usuário**: `PUT /usuarios/atualizar` para atualizar as informações de um usuário. *(Requer token)*



## Tecnologias Utilizadas
- Java;
- Spring Boot;
- MySQL.
## Implementação Futura
- Adição das outras Classes models (Produtos e Usuários) e suas relações no banco de dados;

## 🤝 Colaboradores 
<table>
  <tr>
  <div align="center">
    <td align="center">
      <a href="https://github.com/CajueiroCaio">
        <img src="https://avatars.githubusercontent.com/u/125388047?v=4" width="100px;" alt="Foto de Caio Cajueiro no GitHub"/><br>
        <sub>
          <b>Caio Cajueiro</b>
        </sub>
      </a>
    </td>
      <td align="center">
      <a href="https://github.com/douglasliman">
        <img src="https://avatars.githubusercontent.com/u/98565751?v=4" width="100px;" alt="Foto de Douglas Queiroz no GitHub"/><br>
        <sub>
          <b>Douglas Queiroz</b>
        </sub>
      </a>
    </td>
     <td align="center">
      <a href="https://github.com/SabrinaFurtado">
        <img src="https://avatars.githubusercontent.com/u/145471677?v=4" width="100px;" alt="Foto de Sabrina Furtado no GitHub"/><br>
        <sub>
          <b>Sabrina Furtado</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/pbbyrro">
        <img src="https://avatars.githubusercontent.com/u/62479410?v=4" width="100px;" alt="Foto de Patricia Byrro no GitHub"/><br>
        <sub>
          <b>Patricia Byrro</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Gustavokamimura">
        <img src="https://avatars.githubusercontent.com/u/65565677?v=4" width="100px;" alt="Foto de Gustavo Kamimura no GitHub"/><br>
        <sub>
          <b>Gustavo Kamimura</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/biancavestibulares">
        <img src="https://avatars.githubusercontent.com/u/157066592?v=4" width="100px;" alt="Foto de Bianca Villalba no GitHub"/><br>
        <sub>
          <b>Bianca Villalba</b>
        </sub>
      </a>
    </td>
    </div>
  </tr>
</table>
