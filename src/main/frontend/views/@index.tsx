import { Router } from '@vaadin/router';
import { routes } from './routes.js';
import { appStore } from './stores/app-store.js';

export const router = new Router(document.querySelector('#outlet'));

router.setRoutes(routes);

// Initialize the app store
appStore.init();