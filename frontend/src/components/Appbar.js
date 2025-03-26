import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';

export default function CustomAppbar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar 
        position="fixed" // Fixar o AppBar no topo
        sx={{
          backgroundColor: 'rgba(20, 1, 41, 0.8)', // Cor roxa com transparência
          boxShadow: 'none', // Remover a sombra para dar um visual mais limpo
        }}
      >
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            {/* Ícone de menu (se precisar adicionar) */}
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Agenda SA / Desafio Muralis
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
