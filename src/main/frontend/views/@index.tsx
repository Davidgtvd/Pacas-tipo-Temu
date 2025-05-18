import { ViewConfig } from '@vaadin/hilla-file-router/types.js';

export default function IndexView() {
  return (
    <div style={{
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      justifyContent: 'center',
      height: '80vh',
      padding: '2rem',
      textAlign: 'center',
      color: '#333'
    }}>
      <h1 style={{
        fontSize: '2.5rem',
        marginBottom: '1rem',
        color: '#1676f3'
      }}>
        Aplicación web tipo Temu
      </h1>
      <p style={{
        fontSize: '1.2rem',
        lineHeight: '1.8',
        maxWidth: '600px',
        margin: '0 auto'
      }}>
        Plataforma para venta de <b>pacas de ropa</b> online al por mayor.<br />
        Elige tus pacas, gestiona tus pedidos y transfiere fácilmente.<br />
        <span style={{ color: '#1676f3', fontWeight: 'bold' }}>¡Hecho para Ecuador!</span>
      </p>
    </div>
  );
}

export const config: ViewConfig = {
  title: 'Inicio',
  menu: {
    icon: 'vaadin:home',
    title: 'Inicio',
    order: 0
  }
};