import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
import type Usuario_1 from "./org/unl/pacas/base/models/Usuario.js";
async function createUsuario_1(nombre: string | undefined, contrasena: string | undefined, telefono: string | undefined, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("UsuarioService", "createUsuario", { nombre, contrasena, telefono }, init); }
async function listAllUsuarios_1(init?: EndpointRequestInit_1): Promise<Array<Usuario_1 | undefined> | undefined> { return client_1.call("UsuarioService", "listAllUsuarios", {}, init); }
async function listUsuarios_1(init?: EndpointRequestInit_1): Promise<Array<Record<string, unknown> | undefined> | undefined> { return client_1.call("UsuarioService", "listUsuarios", {}, init); }
async function updateUsuario_1(id: number | undefined, nombre: string | undefined, contrasena: string | undefined, telefono: string | undefined, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("UsuarioService", "updateUsuario", { id, nombre, contrasena, telefono }, init); }
export { createUsuario_1 as createUsuario, listAllUsuarios_1 as listAllUsuarios, listUsuarios_1 as listUsuarios, updateUsuario_1 as updateUsuario };
