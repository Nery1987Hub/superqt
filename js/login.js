document.getElementById('form-login').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede a página de recarregar

    const cpfaluno = document.getElementById('cpfaluno').value;
    const senha = document.getElementById('senha').value;

    const dadosLogin = { cpfaluno, senha };

    fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosLogin)
    })
    .then(response => {
        if (response.ok){
            return response.json();
        }else if (response.status === 401){
            throw new Error('CPF ou senha incorretos.');
        }else{
            throw new Error('Erro interno no servidor.');
        }
    })
    .then(aluno => {
        alert(`Bem-vindo, ${aluno.nome}!`);
        // Aqui você pode salvar o usuário logado no localStorage se precisar:
        // localStorage.setItem('usuarioLogado', JSON.stringify(aluno));
        window.location.href = 'telaFases.html'; 
    })
    .then(usuario => {
    alert(`Bem-vindo, ${usuario.nome}!`);
    
    // Salva os dados na sessão do navegador para saber quem está logado
    localStorage.setItem('usuarioLogado', JSON.stringify(usuario));
    
    // REDIRECIONAMENTO DINÂMICO:
    if (usuario.perfil === 'ADMIN'){
        window.location.href = 'telaListaCadastro.html'; 
    }else{
        window.location.href = 'telaFases.html';
    }
    })
    .catch(error => {
        alert(error.message);
        console.error('Erro no login: ', error);
    });
});