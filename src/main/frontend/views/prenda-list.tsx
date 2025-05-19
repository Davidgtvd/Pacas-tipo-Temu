import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { Button, Dialog, Grid, GridColumn, TextField, VerticalLayout } from '@vaadin/react-components';
import { Notification } from '@vaadin/react-components/Notification';
import * as PrendaService from 'Frontend/generated/PrendaService';
import { useSignal } from '@vaadin/hilla-react-signals';
import { useDataProvider } from '@vaadin/hilla-react-crud';

export const config: ViewConfig = {
  title: 'Prendas',
  route: 'prendas',
  menu: {
    icon: 'vaadin:tshirt',
    order: 2,
    title: 'Prendas',
  },
};

type Prenda = {
  id: string;
  nombre: string;
  descripcion: string;
  talla: string;
  color: string;
};

function PrendaEntryForm({ onPrendaCreated }: { onPrendaCreated?: () => void }) {
  const nombre = useSignal('');
  const descripcion = useSignal('');
  const talla = useSignal('');
  const color = useSignal('');
  const dialogOpened = useSignal(false);

  const createPrenda = async () => {
    try {
      if (nombre.value.trim() && descripcion.value.trim() && talla.value.trim() && color.value.trim()) {
        await PrendaService.save(nombre.value, descripcion.value, talla.value, color.value);
        if (onPrendaCreated) onPrendaCreated();
        nombre.value = '';
        descripcion.value = '';
        talla.value = '';
        color.value = '';
        dialogOpened.value = false;
        Notification.show('Prenda registrada correctamente', { 
          duration: 3000, 
          position: 'bottom-end', 
          theme: 'success' 
        });
      } else {
        Notification.show('Todos los campos son requeridos', { 
          duration: 3000, 
          position: 'top-center', 
          theme: 'error' 
        });
      }
    } catch (error) {
      console.error('Error al guardar prenda:', error);
      Notification.show('Error al registrar la prenda', { 
        duration: 3000, 
        position: 'top-center', 
        theme: 'error' 
      });
    }
  };

  return (
    <>
      <Dialog
        modeless
        headerTitle="Nueva Prenda"
        opened={dialogOpened.value}
        onOpenedChanged={({ detail }) => { dialogOpened.value = detail.value; }}
        footer={
          <>
            <Button onClick={() => (dialogOpened.value = false)}>Cancelar</Button>
            <Button onClick={createPrenda} theme="primary">Registrar</Button>
          </>
        }
      >
        <VerticalLayout style={{ alignItems: 'stretch', width: '18rem', maxWidth: '100%' }}>
          <TextField label="Nombre" required value={nombre.value} onValueChanged={e => (nombre.value = e.detail.value)} />
          <TextField label="Descripción" required value={descripcion.value} onValueChanged={e => (descripcion.value = e.detail.value)} />
          <TextField label="Talla" required value={talla.value} onValueChanged={e => (talla.value = e.detail.value)} />
          <TextField label="Color" required value={color.value} onValueChanged={e => (color.value = e.detail.value)} />
        </VerticalLayout>
      </Dialog>
      <Button 
        onClick={() => (dialogOpened.value = true)}
        theme="primary"
        style={{ marginBottom: '1rem' }}
      >
        Agregar Nueva Prenda
      </Button>
    </>
  );
}

export default function PrendaListView() {
  const dataProvider = useDataProvider({
    list: async () => {
      try {
        const prendas = await PrendaService.listaPrendas();
        return prendas || [];
      } catch (error) {
        console.error('Error al cargar prendas:', error);
        Notification.show('Error al cargar las prendas', { 
          duration: 3000, 
          position: 'top-center', 
          theme: 'error' 
        });
        return [];
      }
    }
  });

  return (
    <div className="p-m" style={{ height: '100%', display: 'flex', flexDirection: 'column' }}>
      <div style={{ 
        display: 'flex', 
        justifyContent: 'space-between', 
        alignItems: 'center',
        marginBottom: '1rem'
      }}>
        <h2 style={{ margin: 0, color: 'var(--lumo-primary-text-color)' }}>
          Gestión de Prendas
        </h2>
        <PrendaEntryForm onPrendaCreated={dataProvider.refresh} />
      </div>

      <Grid 
        dataProvider={dataProvider.dataProvider}
        theme="row-stripes"
        style={{ flex: 1 }}
      >
        <GridColumn path="id" header="ID" width="80px" frozen />
        <GridColumn path="nombre" header="Nombre" autoWidth />
        <GridColumn path="descripcion" header="Descripción" autoWidth />
        <GridColumn path="talla" header="Talla" autoWidth />
        <GridColumn path="color" header="Color" autoWidth />
      </Grid>
    </div>
  );
}