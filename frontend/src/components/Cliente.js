import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useState } from 'react';

export default function BasicTextFields() {
  const [nome, setNome] = useState('');
  const [cpf, setCpf] = useState('');
  const [data_nascimento, setDataNascimento] = useState('');
  const [endereco, setEndereco] = useState('');
  const [clientes, setClientes] = useState([]);
  const [carregando, setCarregando] = useState(false);
  const [clienteSelecionado, setClienteSelecionado] = useState(null);
  const [exibirFormularioCadastro, setExibirFormularioCadastro] = useState(true);
  const [exibirFormularioEdicao, setExibirFormularioEdicao] = useState(false);
  const [exibirListaClientes, setExibirListaClientes] = useState(false);
  const [buscaPor, setBuscaPor] = useState('');
  const [exibirFormularioContato, setExibirFormularioContato] = useState(false);
  const [clienteId, setClienteId] = useState('');
  const [tipo, setTipo] = useState('');
  const [valor, setValor] = useState('');
  const [observacao, setObservacao] = useState('');
  const [contatos, setContatos] = useState([]); // Adiciona estado para contatos
  const[exibirListaContato,setExibirListaContatos] = useState('');


  const handleClick = (e) => {
    e.preventDefault();
    const Cliente = { nome, cpf, data_nascimento, endereco };

    fetch("http://localhost:8080/cliente/salvarCliente", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: JSON.stringify(Cliente)
    })
    .then(response => response.json())
    .then(data => {
      alert("Cliente cadastrado com sucesso!");
      handleListarClientes();
    })
    .catch(error => console.error("Erro ao cadastrar:", error));
  };

  const handleListarClientes = () => {
    setCarregando(true);
    fetch("http://localhost:8080/cliente/listarClientes")
      .then(res => res.json())
      .then((resposta) => {
        setClientes(resposta);
        setCarregando(false);
        setExibirListaClientes(true);
        setExibirFormularioCadastro(false);
      })
      .catch((error) => {
        console.error("Erro ao listar clientes:", error);
        setCarregando(false);
      });
  };

  const handleBuscarCliente = () => {
    setCarregando(true);
    fetch(`http://localhost:8080/cliente/buscarPorNomeOuCpf?buscaPor=${buscaPor}`)
      .then(res => res.json())
      .then((resposta) => {
        setClientes(resposta);
        setCarregando(false);
        setExibirListaClientes(true);
        setExibirFormularioCadastro(false);
        setExibirFormularioEdicao(false);
      })
      .catch((error) => {
        console.error("Erro ao buscar cliente:", error);
        setCarregando(false);
      });
  };

  const handleEditarCliente = (e) => {
    e.preventDefault();
    if (!clienteSelecionado) return;

    const ClienteAtualizado = {
      id: clienteSelecionado.id,
      nome,
      cpf,
      data_nascimento,
      endereco,
    };

    fetch(`http://localhost:8080/cliente/editarCliente/${clienteSelecionado.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json",
      },
      body: JSON.stringify(ClienteAtualizado),
    })
    .then((response) => {
      if (!response.ok) {
        return response.text().then(text => { throw new Error(`Erro: ${response.status} - ${text}`); });
      }
      return response.text();
    })
    .then((data) => {
      console.log(data);
      alert(data);
      setClienteSelecionado(null);
      setNome("");
      setCpf("");
      setDataNascimento("");
      setEndereco("");
      setExibirFormularioEdicao(false);
      setExibirFormularioCadastro(true);
      setExibirListaClientes(false);
    })
    .catch((error) => {
      console.error("Erro ao atualizar:", error);
    });
  };

  const handleExcluirCliente = () => {
    if (!clienteSelecionado) return;

    fetch(`http://localhost:8080/cliente/excluir/${clienteSelecionado.id}`, {
      method: "DELETE",
    })
    .then((response) => {
      if (!response.ok) {
        return response.text().then(text => { throw new Error(`Erro: ${response.status} - ${text}`); });
      }
      return response.text();
    })
    .then((data) => {
      console.log(data);
      alert("Cliente excluído com sucesso!");
      setClienteSelecionado(null);
      setNome("");
      setCpf("");
      setDataNascimento("");
      setEndereco("");
      setExibirFormularioEdicao(false);
      setExibirFormularioCadastro(true);
      handleListarClientes();
    })
    .catch((error) => {
      console.error("Erro ao excluir:", error);
    });
  };

  const handleExibirInformacoes = (cliente) => {
    setClienteSelecionado(cliente);
    setNome(cliente.nome);
    setCpf(cliente.cpf);
    setDataNascimento(cliente.data_nascimento);
    setEndereco(cliente.endereco);
    setExibirFormularioCadastro(false);
    setExibirFormularioEdicao(true);
    setExibirListaClientes(false);
  };

  const handleVoltar = () => {
    setExibirFormularioCadastro(true);
    setExibirFormularioEdicao(false);
    setExibirListaClientes(false);
    setBuscaPor('');
  };

  const handleSalvarContato = () => {
    alert("Contato cadastrado!");  // Alerta após salvar
    if (!clienteId || !tipo || !valor) {
      alert("Por favor, preencha todos os campos.");
      return;
    }
  
    const novoContato = {
      clienteId,
      tipo,
      valor,
      observacao,
    };
  
    fetch('http://localhost:8080/contato/salvarContato', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(novoContato),
    })
    .then(response => response.json())
    .then(data => {
      alert("Contato cadastrado com sucesso!");
      setClienteId('');
      setTipo('');
      setValor('');
      setObservacao('');
    })
    .catch(error => {
      console.error('Erro ao salvar contato:', error);
    });
  };

  const handleListarContatos = (clienteId) => {
  setCarregando(true);
  fetch(`http://localhost:8080/contato/buscarPorId/${clienteId}`)
    .then(res => res.json())
    .then((resposta) => {
      setContatos(resposta);
      setCarregando(false);
      setExibirListaContatos(true); // Exibe a lista de contatos
    })
    .catch((error) => {
      console.error("Erro ao listar contatos:", error);
      setCarregando(false);
    });
};

  

  return (
    <div 
      style={{
        backgroundImage: 'url(https://source.unsplash.com/random/1600x900/?abstract,tech)',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        height: '100vh', 
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center'
      }}
    >
      {/* Formulário de cadastro de cliente */}
      {exibirFormularioCadastro && (
        <Box
          component="form"
          sx={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            padding: '50px',
            background: 'rgba(230, 226, 226, 0.7)', 
            borderRadius: '12px',
            boxShadow: '0 0 30px 5px rgba(138, 43, 226, 0.8)', 
            width: '350px', 
          }}
          noValidate
          autoComplete="off"
        >
          <h1 style={{ color: 'black' }}><u>Cadastro de Cliente</u></h1>
          
          <TextField
            id="outlined-basic"
            label="Nome*:"
            variant="outlined"
            fullWidth
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            sx={{ marginBottom: '15px' }}
          />
          
          <TextField
            id="outlined-basic"
            label="CPF*:"
            variant="outlined"
            fullWidth
            value={cpf}
            onChange={(e) => setCpf(e.target.value)}
            sx={{ marginBottom: '15px' }}
          />
          
          <TextField
            id="outlined-basic"
            label="Data de Nascimento*:"
            fullWidth
            value={data_nascimento}
            onChange={(e) => setDataNascimento(e.target.value)}
            sx={{ marginBottom: '15px' }}
          />
          
          <TextField
            id="outlined-basic"
            label="Endereço"
            variant="outlined"
            fullWidth
            value={endereco}
            onChange={(e) => setEndereco(e.target.value)}
            sx={{ marginBottom: '15px' }}
          />
        {exibirFormularioContato && (
  <Box
    component="form"
    sx={{
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      padding: '50px',
      background: 'rgba(230, 226, 226, 0.7)', 
      borderRadius: '12px',
      boxShadow: '0 0 30px 5px rgba(43, 136, 226, 0.8)', 
      width: '350px', 
      marginTop: '20px'
    }}
    noValidate
    autoComplete="off"
  >
    <h1 style={{ color: 'black' }}><u>Cadastro de Contato</u></h1>

    <TextField
  id="outlined-basic"
  label="Cliente Id"
  variant="outlined"
  fullWidth
  value={clienteId}
  onChange={(e) => setClienteId(e.target.value)}
  sx={{ marginBottom: '15px' }}
/>
<TextField
  id="outlined-basic"
  label="Tipo"
  variant="outlined"
  fullWidth
  value={tipo}
  onChange={(e) => setTipo(e.target.value)}
  sx={{ marginBottom: '15px' }}
/>
<TextField
  id="outlined-basic"
  label="Valor"
  variant="outlined"
  fullWidth
  value={valor}
  onChange={(e) => setValor(e.target.value)}
  sx={{ marginBottom: '15px' }}
/>
<TextField
  id="outlined-basic"
  label="Observação"
  variant="outlined"
  fullWidth
  value={observacao}
  onChange={(e) => setObservacao(e.target.value)}
  sx={{ marginBottom: '15px' }}
/>

    <Box sx={{ display: 'flex', justifyContent: 'center', gap: '15px', marginTop: '20px' }}>
    <Button
  variant="contained"
  disableElevation
  onClick={handleSalvarContato}  // Chame a função diretamente
  sx={{
    background: 'blue',
    color: 'white',
    '&:hover': {
      background: 'darkblue',
    }
  }}
>
  Salvar Contato
</Button>

      <Button
        variant="outlined"
        color="secondary"
        onClick={() => setExibirFormularioContato(false)}
      >
        Fechar
      </Button>
    </Box>
    <Box sx={{ marginTop: '20px' }}>
  <Button
    variant="contained"
    disableElevation
    onClick={() => handleListarContatos(clienteSelecionado?.id)}
    sx={{
      background: 'blue',
      color: 'white',
      '&:hover': {
        background: 'blue',
      }
    }}
  >
    Listar Contatos
  </Button>
</Box>


  </Box>
)}


          
          <Box sx={{ display: 'flex', justifyContent: 'center', gap: '15px', marginTop: '20px' }}>
            <Button
              variant="contained"
              disableElevation
              onClick={handleClick}
              sx={{
                background: 'purple',
                color: 'white',
                '&:hover': {
                  background: 'purple',
                }
              }}
            >
              Cadastrar
            </Button>
            <Button
              variant="contained"
              disableElevation
              onClick={handleListarClientes}
              sx={{
                background: 'green',
                color: 'white',
                '&:hover': {
                  background: 'green',
                }
              }}
            >
              {carregando ? "Carregando..." : "Listar Clientes"}
            </Button>

        <Button
            variant="contained"
            disableElevation
            onClick={() => setExibirFormularioContato(true)} // Abre o formulário de contato
            sx={{
            background: 'blue',
            color: 'white',
            '&:hover': {
                background: 'darkblue',
            }
            }}
        >
            Cadastrar Contato
        </Button>

          </Box>

          {/* Campo de busca e botão voltar */}
          <Box sx={{ display: 'flex', flexDirection: 'row', alignItems: 'center', gap: '15px', marginTop: '15px' }}>
            <TextField
              label="Buscar por Nome ou CPF"
              variant="outlined"
              value={buscaPor}
              onChange={(e) => setBuscaPor(e.target.value)}
              fullWidth
            />
            <Button
              variant="contained"
              color="primary"
              onClick={handleBuscarCliente}
              disabled={carregando}
            >
              {carregando ? "Buscando..." : "Buscar"}
            </Button>
          </Box>
          <Box sx={{ marginTop: '15px' }}>
            <Button
              variant="outlined"
              color="secondary"
              onClick={handleVoltar}
            >
              Voltar
            </Button>
          </Box>
        </Box>
      )}

      {/* Formulário de edição de cliente */}
      {exibirFormularioEdicao && (
        <Box
          component="form"
          sx={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            padding: '50px',
            background: 'rgba(230, 226, 226, 0.7)', 
            borderRadius: '12px',
            boxShadow: '0 0 30px 5px rgba(138, 43, 226, 0.8)', 
            width: '350px', 
          }}
          noValidate
          autoComplete="off"
        >
          <h1 style={{ color: 'black' }}><u>Editar Cliente</u></h1>
          
          <TextField
            id="outlined-basic"
            label="Nome*:"
            variant="outlined"
            fullWidth
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            sx={{ marginBottom: '15px' }}
          />
          
          <TextField
            id="outlined-basic"
            label="CPF*:"
            variant="outlined"
            fullWidth
            value={cpf}
            onChange={(e) => setCpf(e.target.value)}
            sx={{ marginBottom: '15px' }}
          />
          
          <TextField
            id="outlined-basic"
            label="Data de Nascimento*:"
            fullWidth
            value={data_nascimento}
            onChange={(e) => setDataNascimento(e.target.value)}
            sx={{ marginBottom: '15px' }}
          />
          
          <TextField
            id="outlined-basic"
            label="Endereço"
            variant="outlined"
            fullWidth
            value={endereco}
            onChange={(e) => setEndereco(e.target.value)}
            sx={{ marginBottom: '15px' }}
          />
          
          <Box sx={{ display: 'flex', justifyContent: 'center', gap: '15px', marginTop: '20px' }}>
            <Button
              variant="contained"
              disableElevation
              onClick={handleEditarCliente}
              sx={{
                background: 'purple',
                color: 'white',
                '&:hover': {
                  background: 'purple',
                }
              }}
            >
              Atualizar
            </Button>
            <Button
              variant="contained"
              disableElevation
              onClick={handleExcluirCliente}
              sx={{
                background: 'red',
                color: 'white',
                '&:hover': {
                  background: 'red',
                }
              }}
            >
              Excluir
            </Button>
          </Box>

          {/* Voltar para o formulário de cadastro */}
          <Box sx={{ marginTop: '15px' }}>
            <Button
              variant="outlined"
              color="secondary"
              onClick={handleVoltar}
            >
              Voltar
            </Button>
          </Box>
        </Box>
      )}

      {/* Lista de Clientes */}
      {exibirListaClientes && (
        <Box sx={{
          padding: '30px',
          borderRadius: '12px',
          background: 'rgba(230, 226, 226, 0.7)', 
          boxShadow: '0 0 30px 5px rgba(138, 43, 226, 0.8)',
          marginTop: '30px',
          overflow: 'auto',
          height: '300px',
          width: '100%'
        }}>
          <Typography variant="h5">Clientes Cadastrados</Typography>
          {clientes.map((cliente) => (
            <Box
              key={cliente.id}
              sx={{
                marginBottom: '10px',
                padding: '15px',
                background: 'white',
                borderRadius: '8px',
                boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
                display: 'flex',
                justifyContent: 'space-between',
                alignItems: 'center',
              }}
            >
              <Typography>{cliente.nome}</Typography>
              <Button
                variant="outlined"
                color="primary"
                onClick={() => handleExibirInformacoes(cliente)}
              >
                Editar
              </Button>
            </Box>
          ))}
        </Box>
      )}
    </div>
  );
}
