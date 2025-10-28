# language: pt
Funcionalidade: Fluxo de Compra do SauceDemo
  Como um usuário, eu quero poder logar e adicionar itens ao carrinho
  para que eu possa finalizar uma compra.

  Cenario: Adicionar um item ao carrinho com sucesso
    Dado que eu esteja na pagina de login do SauceDemo
    Quando eu preencher o usuario com "standard_user"
    E eu preencher a senha com "secret_sauce"
    E eu clicar no botao de login
    Entao eu devo ser redirecionado para a pagina de produtos
    Quando eu adicionar o produto "Sauce Labs Backpack" ao carrinho
    E eu clicar no icone do carrinho
    Entao eu devo ver o produto "Sauce Labs Backpack" na pagina do carrinho