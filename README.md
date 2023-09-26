# unexusprueba
## En el archibo base.sql se encuentra el modelo de base de datos
### API
POST http://localhost:8080/cliente/insertar
```json
{
    "ruc": "1001020338",
    "razonSocial": "cliente unexus",
    "clienteSucursalUnexus": [
        {
            "direccion": "Ibarra"
        }
    ]
}
```

PUT http://localhost:8080/cliente/actualizar/datos
```json
{
    "ruc":"1001020338", //busca por ruc y actualiza
    "razonSocial": "cliente unexus actualizado"
}
```
PUT http://localhost:8080/cliente/insertar/nueva/direccion
```json
{
    "idClienteUnexus":1,
    "direccion": "Urcuqui"
}
```
DELETE http://localhost:8080/cliente/eliminar/{idClienteUnexus}
GET http://localhost:8080/cliente/obtener/direcciones/{idClienteUnexus}
GET  http://localhost:8080/cliente/obtener/datos/{rucrazon}
