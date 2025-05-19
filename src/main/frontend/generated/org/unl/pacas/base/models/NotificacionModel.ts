import { _getPropertyModel as _getPropertyModel_1, BooleanModel as BooleanModel_1, makeObjectEmptyValueCreator as makeObjectEmptyValueCreator_1, NumberModel as NumberModel_1, ObjectModel as ObjectModel_1, StringModel as StringModel_1 } from "@vaadin/hilla-lit-form";
import type Notificacion_1 from "./Notificacion.js";
class NotificacionModel<T extends Notificacion_1 = Notificacion_1> extends ObjectModel_1<T> {
    static override createEmptyValue = makeObjectEmptyValueCreator_1(NotificacionModel);
    get id(): NumberModel_1 {
        return this[_getPropertyModel_1]("id", (parent, key) => new NumberModel_1(parent, key, true, { meta: { javaType: "java.lang.Integer" } }));
    }
    get mensaje(): StringModel_1 {
        return this[_getPropertyModel_1]("mensaje", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get fecha(): StringModel_1 {
        return this[_getPropertyModel_1]("fecha", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.util.Date" } }));
    }
    get leida(): BooleanModel_1 {
        return this[_getPropertyModel_1]("leida", (parent, key) => new BooleanModel_1(parent, key, true, { meta: { javaType: "java.lang.Boolean" } }));
    }
}
export default NotificacionModel;
