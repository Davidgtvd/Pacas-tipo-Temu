import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
import type Direccion_1 from "./org/unl/pacas/base/models/Direccion.js";
async function createDireccion_1(calle: string | undefined, ciudad: string | undefined, estado: string | undefined, codigoPostal: string | undefined, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("DireccionService", "createDireccion", { calle, ciudad, estado, codigoPostal }, init); }
async function listAllDirecciones_1(init?: EndpointRequestInit_1): Promise<Array<Direccion_1 | undefined> | undefined> { return client_1.call("DireccionService", "listAllDirecciones", {}, init); }
async function listDirecciones_1(init?: EndpointRequestInit_1): Promise<Array<Record<string, unknown> | undefined> | undefined> { return client_1.call("DireccionService", "listDirecciones", {}, init); }
async function updateDireccion_1(id: number | undefined, calle: string | undefined, ciudad: string | undefined, estado: string | undefined, codigoPostal: string | undefined, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("DireccionService", "updateDireccion", { id, calle, ciudad, estado, codigoPostal }, init); }
export { createDireccion_1 as createDireccion, listAllDirecciones_1 as listAllDirecciones, listDirecciones_1 as listDirecciones, updateDireccion_1 as updateDireccion };
