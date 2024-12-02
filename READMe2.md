<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Media App</title>
    <style>
        body {
            padding: 0;
            margin: 0;
            height: auto;
            background: url('https://wallpaperaccess.com/full/200687.jpg');
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
            color: blue;
        }

        h1 {
            text-align: center;
            font-size: 40px;
            color: white;
        }

        .container {
            margin: 0 auto;
            padding: 20px;
            width: 80%;
            max-width: 600px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 8px;
        }

        .input-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-size: 16px;
        }

        input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            width: 100%;
            padding: 10px;
            font-size: 18px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .results {
            margin-top: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border-radius: 8px;
        }

        .result-item {
            margin-bottom: 10px;
        }

        .result-item span {
            font-weight: bold;
        }

        .status-exemplar {
            color: green;
        }

        .status-aprovado {
            color: blue;
        }

        .status-reprovado {
            color: red;
        }
    </style>
</head>
<body>

    <h1>Média App</h1>

    <div class="container">
        <div class="input-group">
            <label for="numAlunos">Número de alunos:</label>
            <input type="number" id="numAlunos" placeholder="Informe o número de alunos" />
        </div>

        <div id="alunosForm"></div>
        <button id="submitBtn">Calcular Médias</button>

        <div id="results" class="results"></div>
    </div>

    <script>
        // Função para criar campos de cadastro de alunos
        document.getElementById('numAlunos').addEventListener('input', function() {
            let numAlunos = parseInt(this.value);
            let formContainer = document.getElementById('alunosForm');
            formContainer.innerHTML = ''; // Limpa o formulário antes de recriar os campos

            if (numAlunos > 0 && numAlunos <= 100) {
                for (let i = 0; i < numAlunos; i++) {
                    let alunoDiv = document.createElement('div');
                    alunoDiv.classList.add('input-group');
                    alunoDiv.innerHTML = `
                        <h3>Cadastro do aluno ${i + 1}:</h3>
                        <label for="nome${i}">Nome do aluno:</label>
                        <input type="text" id="nome${i}" placeholder="Digite o nome do aluno" />
                        <label for="nota1${i}">Primeira nota:</label>
                        <input type="number" step="0.01" id="nota1${i}" placeholder="Digite a primeira nota" />
                        <label for="nota2${i}">Segunda nota:</label>
                        <input type="number" step="0.01" id="nota2${i}" placeholder="Digite a segunda nota" />
                    `;
                    formContainer.appendChild(alunoDiv);
                }
            }
        });

        // Função para calcular a média e classificar os alunos
        document.getElementById('submitBtn').addEventListener('click', function() {
            let numAlunos = parseInt(document.getElementById('numAlunos').value);
            let resultsContainer = document.getElementById('results');
            resultsContainer.innerHTML = '';

            let aprovados = 0, reprovados = 0, exemplares = 0;
            let alunos = [];

            // Coleta os dados dos alunos
            for (let i = 0; i < numAlunos; i++) {
                let nome = document.getElementById(`nome${i}`).value;
                let nota1 = parseFloat(document.getElementById(`nota1${i}`).value);
                let nota2 = parseFloat(document.getElementById(`nota2${i}`).value);

                if (nome && !isNaN(nota1) && !isNaN(nota2)) {
                    let media = (nota1 + nota2) / 2;
                    let status = '';

                    if (media >= 9) {
                        status = 'Exemplar';
                        exemplares++;
                    } else if (media >= 7) {
                        status = 'Aprovado';
                        aprovados++;
                    } else {
                        status = 'Reprovado';
                        reprovados++;
                    }

                    alunos.push({ nome, nota1, nota2, media, status });
                }
            }

            // Ordena os alunos pela média
            alunos.sort((a, b) => b.media - a.media);

            // Exibe os resultados
            alunos.forEach(aluno => {
                let statusClass = '';
                if (aluno.status === 'Exemplar') statusClass = 'status-exemplar';
                if (aluno.status === 'Aprovado') statusClass = 'status-aprovado';
                if (aluno.status === 'Reprovado') statusClass = 'status-reprovado';

                resultsContainer.innerHTML += `
                    <div class="result-item">
                        <span>Aluno:</span> ${aluno.nome}<br />
                        <span>Notas:</span> ${aluno.nota1}, ${aluno.nota2}<br />
                        <span>Média:</span> ${aluno.media.toFixed(2)}<br />
                        <span class="${statusClass}">Status: ${aluno.status}</span>
                    </div>
                `;
            });

            // Exibe o total de alunos
            resultsContainer.innerHTML += `
                <div><strong>Total de alunos aprovados:</strong> ${aprovados}</div>
                <div><strong>Total de alunos reprovados:</strong> ${reprovados}</div>
                <div><strong>Total de alunos exemplares:</strong> ${exemplares}</div>
            `;
        });
    </script>
</body>
</html>
