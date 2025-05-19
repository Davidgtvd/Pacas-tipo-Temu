import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
import type Notificacion_1 from "./org/unl/pacas/base/models/Notificacion.js";
async function createNotificacion_1(mensaje: string | undefined, fecha: string | undefined, leida: string | undefined, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("NotificacionService", "createNotificacion", { mensaje, fecha, leida }, init); }
async function listAllNotificaciones_1(init?: EndpointRequestInit_1): Promise<Array<Notificacion_1 | undefined> | undefined> { return client_1.call("NotificacionService", "listAllNotificaciones", {}, init); }
async function listNotificaciones_1(init?: EndpointRequestInit_1): Promise<Array<Record<string, unknown> | undefined> | undefined> { return client_1.call("NotificacionService", "listNotificaciones", {}, init); }
export { createNotificacion_1 as createNotificacion, listAllNotificaciones_1 as listAllNotificaciones, listNotificaciones_1 as listNotificaciones };
