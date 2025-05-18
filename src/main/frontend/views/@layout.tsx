import { AppLayout } from '@vaadin/react-components/AppLayout.js';
import { DrawerToggle } from '@vaadin/react-components/DrawerToggle.js';
import { Scroller } from '@vaadin/react-components/Scroller.js';
import { Outlet, NavLink } from 'react-router';

export default function Layout() {
  return (
    <AppLayout primarySection="drawer">
      <DrawerToggle slot="navbar" aria-label="Menu toggle" />
      
      <h2 slot="navbar" style={{ 
        margin: 0, 
        fontSize: '1.5rem',
        fontWeight: '600',
        color: 'var(--lumo-primary-text-color)'
      }}>
        Vaadin Pacas
      </h2>

      <Scroller slot="drawer" style={{
        padding: 'var(--lumo-space-s)',
        backgroundColor: 'var(--lumo-base-color)',
        borderRight: '1px solid var(--lumo-contrast-10pct)'
      }}>
        <nav>
          <NavLink 
            to="/"
            style={({ isActive }) => ({
              display: 'block',
              padding: 'var(--lumo-space-s) var(--lumo-space-m)',
              textDecoration: 'none',
              color: isActive ? 'var(--lumo-primary-text-color)' : 'var(--lumo-secondary-text-color)',
              backgroundColor: isActive ? 'var(--lumo-primary-color-10pct)' : 'transparent',
              borderRadius: 'var(--lumo-border-radius-m)',
              marginBottom: 'var(--lumo-space-xs)',
              transition: 'all 0.3s'
            })}
          >
            Inicio
          </NavLink>
          
          <NavLink 
            to="/pacas"
            style={({ isActive }) => ({
              display: 'block',
              padding: 'var(--lumo-space-s) var(--lumo-space-m)',
              textDecoration: 'none',
              color: isActive ? 'var(--lumo-primary-text-color)' : 'var(--lumo-secondary-text-color)',
              backgroundColor: isActive ? 'var(--lumo-primary-color-10pct)' : 'transparent',
              borderRadius: 'var(--lumo-border-radius-m)',
              marginBottom: 'var(--lumo-space-xs)',
              transition: 'all 0.3s'
            })}
          >
            Gestión de Pacas
          </NavLink>
        </nav>
      </Scroller>

      <div slot="content" style={{
        height: '100%',
        overflow: 'auto',
        padding: 'var(--lumo-space-m)'
      }}>
        <Outlet />
      </div>
    </AppLayout>
  );
}