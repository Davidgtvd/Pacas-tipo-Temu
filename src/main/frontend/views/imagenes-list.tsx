import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { Button, Dialog, Grid, GridColumn, TextField, VerticalLayout } from '@vaadin/react-components';
import { Notification } from '@vaadin/react-components/Notification';
import * as ImagenService from 'Frontend/generated/ImagenService';
import { useSignal } from '@vaadin/hilla-react-signals';
import { useDataProvider } from '@vaadin/hilla-react-crud';

export const config: ViewConfig = {
  title: 'Imágenes',
  route: 'imagenes',
  menu: {
    icon: 'vaadin:picture',
    order: 3,
    title: 'Imágenes',
  },
};

type Imagen = {
  id: string;
  url: string;
  prendaId?: string;
  pacaId?: string;
};

function ImagenEntryForm({ onImagenCreated }: { onImagenCreated?: () => void }) {
  const url = useSignal('');
  const prendaId = useSignal('');
  const pacaId = useSignal('');
  const dialogOpened = useSignal(false);

  const createImagen = async () => {
    try {
      if (url.value.trim()) {
        await ImagenService.save(url.value, prendaId.value || null, pacaId.value || null);
        if (onImagenCreated) onImagenCreated();
        url.value = '';
        prendaId.value = '';
        pacaId.value = '';
        dialogOpened.value = false;
        Notification.show('Imagen registrada correctamente', { 
          duration: 3000, 
          position: 'bottom-end', 
          theme: 'success' 
        });
      } else {
        Notification.show('El campo URL es requerido', { 
          duration: 3000, 
          position: 'top-center', 
          theme: 'error' 
        });
      }
    } catch (error) {
      console.error('Error al guardar imagen:', error);
      Notification.show('Error al registrar la imagen', { 
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
        headerTitle="Nueva Imagen"
        opened={dialogOpened.value}
        onOpenedChanged={({ detail }) => { dialogOpened.value = detail.value; }}
        footer={
          <>
            <Button onClick={() => (dialogOpened.value = false)}>Cancelar</Button>
            <Button onClick={createImagen} theme="primary">Registrar</Button>
          </>
        }
      >
        <VerticalLayout style={{ alignItems: 'stretch', width: '18rem', maxWidth: '100%' }}>
          <TextField label="URL" required value={url.value} onValueChanged={e => (url.value = e.detail.value)} />
          <TextField label="ID Prenda (opcional)" value={prendaId.value} onValueChanged={e => (prendaId.value = e.detail.value)} />
          <TextField label="ID Paca (opcional)" value={pacaId.value} onValueChanged={e => (pacaId.value = e.detail.value)} />
        </VerticalLayout>
      </Dialog>
      <Button 
        onClick={() => (dialogOpened.value = true)}
        theme="primary"
        style={{ marginBottom: '1rem' }}
      >
        Agregar Nueva Imagen
      </Button>
    </>
  );
}

export default function ImagenListView() {
  const dataProvider = useDataProvider({
    list: async () => {
      try {
        const imagenes = await ImagenService.listaImagenes();
        return imagenes || [];
      } catch (error) {
        console.error('Error al cargar imágenes:', error);
        Notification.show('Error al cargar las imágenes', { 
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
          Gestión de Imágenes
        </h2>
        <ImagenEntryForm onImagenCreated={dataProvider.refresh} />
      </div>

      <Grid 
        dataProvider={dataProvider.dataProvider}
        theme="row-stripes"
        style={{ flex: 1 }}
      >
        <GridColumn path="id" header="ID" width="80px" frozen />
        <GridColumn path="url" header="URL" autoWidth />
        <GridColumn path="prendaId" header="ID Prenda" autoWidth />
        <GridColumn path="pacaId" header="ID Paca" autoWidth />
      </Grid>
    </div>
  );
}