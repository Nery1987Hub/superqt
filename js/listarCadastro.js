// Executa assim que a página carrega
document.addEventListener("DOMContentLoaded", () => {
    const usuario = JSON.parse(localStorage.getItem('usuarioLogado'));
    
    // Segurança básica de front-end: se não for admin, expulsa da página
    if (!usuario || usuario.perfil !== 'ADMIN') {
        alert("Acesso negado!");
        window.location.href = 'login.html';
        return;
    }

    carregarAlunos();
});

function carregarAlunos() {
    fetch('http://localhost:8080/aluno')
    .then(res => res.json())
    .then(alunos => {
        const corpoTabela = document.getElementById('tabelaAlunos');
        corpoTabela.innerHTML = ''; // Limpa a tabela

        alunos.forEach(aluno => {
            // Não mostra outros administradores na lista de alunos, se houver
            if(aluno.perfil === 'ADMIN') return; 

            corpoTabela.innerHTML += `
                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.cpfaluno}</td>
                    <td>${aluno.nome}</td>
                    <td>${aluno.idade}</td>
                    <td>
                        <button onclick="deletarAluno(${aluno.id})">
                            <img src="assets/images/icon-excluir.png" alt="Excluir" height="30">
                        </button>
                    </td>
                </tr>
            `;
        });
    });
}

function deletarAluno(id) {
    if(confirm("Tem certeza que deseja excluir este aluno?")) {
        fetch(`http://localhost:8080/aluno/${id}`, { method: 'DELETE' })
        .then(res => {
            if(res.ok) {
                alert("Aluno excluído!");
                carregarAlunos(); // Atualiza a tabela
            }
        });
    }
}
