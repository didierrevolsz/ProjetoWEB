

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>

    function salvar() {
        alert("teste");
        alert(document.getElementById("email").value);

        document.getElementById("formulario").submit();
       
    }
    
    
        function limpa_formulário_cep() {
            //Limpa valores do formulário de cep.
            document.getElementById('rua').value = ("");
            document.getElementById('bairro').value = ("");
            document.getElementById('cidade').value = ("");

        }

        function meu_callback(conteudo) {
            if (!("erro" in conteudo)) {
                //Atualiza os campos com os valores.
                document.getElementById('rua').value = (conteudo.logradouro);
                document.getElementById('bairro').value = (conteudo.bairro);
                document.getElementById('cidade').value = (conteudo.localidade);
                document.getElementById('uf').value = (conteudo.uf);

            } //end if.
            else {
                //CEP não Encontrado.
                limpa_formulário_cep();
                alert("CEP não encontrado.");
            }
        }

        function pesquisacep(valor) {

            //Nova variável "cep" somente com dígitos.
            var cep = valor.replace(/\D/g, '');

            //Verifica se campo cep possui valor informado.
            if (cep != "") {

                //Expressão regular para validar o CEP.
                var validacep = /^[0-9]{8}$/;

                //Valida o formato do CEP.
                if (validacep.test(cep)) {

                    //Preenche os campos com "..." enquanto consulta webservice.
                    document.getElementById('rua').value = "...";
                    document.getElementById('bairro').value = "...";
                    document.getElementById('cidade').value = "...";
                    document.getElementById('uf').value = "...";


                    //Cria um elemento javascript.
                    var script = document.createElement('script');

                    //Sincroniza com o callback.
                    script.src = 'https://viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';

                    //Insere script no documento e carrega o conteúdo.
                    document.body.appendChild(script);

                } //end if.
                else {
                    //cep é inválido.
                    limpa_formulário_cep();
                    alert("Formato de CEP inválido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formulário.
                limpa_formulário_cep();
            }
        }
            
</script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Adicionando Javascript PONTO DE RETORNO--> 

    </head>
    <body>
        <div align="center">
            <h1>Cadastro Transportadora - teste campos limitados</h1>
            <form action="${pageContext.request.contextPath}/TransportadoraControlador?acao=inserir" method="post" id="formulario">
                <table style="with: 80%">
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" id="email" /></td>
                    </tr>
                    <tr>
                        <td>Nome</td>
                        <td><input type="text" name="nome" /></td>
                    </tr>
                    <tr>
                        <td>Empresa</td>
                        <td><input type="text" name="empresa" /></td>
                    </tr>
                    <tr>
                        <td>Telefone</td>
                        <td><input type="telefone" name="telefone" /></td>
                    </tr>

                    <tr>
                        <td>Celular</td>
                        <td><input type="celular" name="celular" /></td>
                    </tr>
                    <tr>
                        <td>Whatsapp</td>
                        <td><input type="whatsapp" name="whatsapp" /></td>
                    </tr>
                    <!-- MODAL -->
                    <tr>
                        <td>Modal</td>
                        <td><select name="modal" id="modal">
                                <option value="">Selecione</option>
                                <option>Rodoviario(120)</option>
                                <option>Aereo(110)</option>
                                <option>Aquaviario(90)</option>

                            </select></td>
                    </tr>

                    <!-- TESTE DE CEP-->
                    <label>Cep:
                        <input name="cep" type="text" id="cep" value="" size="10" maxlength="9"
                               onblur="pesquisacep(this.value);" /></label><br />
                    <label>Rua:
                        <input name="rua" type="text" id="rua" size="60" /></label><br />
                    <label>Bairro:
                        <input name="bairro" type="text" id="bairro" size="40" /></label><br />
                    <label>Cidade:
                        <input name="cidade" type="text" id="cidade" size="40" /></label><br />
                    <label>Estado:
                        <input name="uf" type="text" id="uf" size="2" /></label><br />
                    




                </table>
                <input type="button" onclick="salvar()" value="cadastro"/>
            </form>
        </div>
    </body>
</html>
