# unexusprueba
en el archibo base.sql se encuentra el modelo de base de datos
POST http://localhost:8080/cliente/insertar
{
    "ruc":"1001020338",
    "razonSocial": "cliente unexus",
    "clienteSucursalUnexus":[
        {
            "direccion":"Ibarra"
        }
    ]
}

PUT http://localhost:8080/cliente/actualizar/datos
{
    "ruc":"1001020338", //busca por ruc y actualiza
    "razonSocial": "cliente unexus actualizado"
}
