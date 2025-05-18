import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
async function listaPacas_1(init?: EndpointRequestInit_1): Promise<Array<Record<string, string | undefined> | undefined> | undefined> { return client_1.call("PacaService", "listaPacas", {}, init); }
async function save_1(nombre: string | undefined, descripcion: string | undefined, init?: EndpointRequestInit_1): Promise<Record<string, string | undefined> | undefined> { return client_1.call("PacaService", "save", { nombre, descripcion }, init); }
export { listaPacas_1 as listaPacas, save_1 as save };
