use empresa;

-- Insertar usuario
DELIMITER //
CREATE PROCEDURE SP_InsertarUsuario(
    IN v_usuario_id VARCHAR(15),
    IN v_nombre VARCHAR(130),
    IN v_clave VARCHAR(30),
    IN v_rol VARCHAR(30),
    IN v_estado VARCHAR(11)
)
BEGIN
    INSERT INTO tb_usuario(idUsuario, nombre, password, rol, estado)
    VALUES(v_usuario_id, v_nombre, v_clave, v_rol, v_estado);
END;
//
DELIMITER ;

-- Modificar usuario
DELIMITER //
CREATE PROCEDURE SP_ModificarUsuario(
    IN v_usuario_id VARCHAR(15),
    IN v_nombre VARCHAR(130),
    IN v_clave VARCHAR(30),
    IN v_rol VARCHAR(30),
    IN v_estado VARCHAR(11)
)
BEGIN
    UPDATE tb_usuario
    SET nombre = v_nombre,
        password = v_clave,
        rol = v_rol,
        estado = v_estado
    WHERE idUsuario = v_usuario_id;
END;
//
DELIMITER ;

-- Eliminar (inactivar) usuario
DELIMITER //
CREATE PROCEDURE SP_EliminarUsuario(
    IN v_usuario_id VARCHAR(15)
)
BEGIN
    UPDATE tb_usuario
    SET estado = 'Inactivo'
    WHERE idUsuario = v_usuario_id;
END;
//
DELIMITER ;

-- Insertar categoría
DELIMITER //
CREATE PROCEDURE SP_InsertarCategoria(
    IN v_nombre_categoria VARCHAR(100),
    IN v_descripcion_categoria VARCHAR(100),
    IN v_estado_categoria VARCHAR(11)
)
BEGIN
    INSERT INTO tb_categoria(nombre, descripcion, estado)
    VALUES(v_nombre_categoria, v_descripcion_categoria, v_estado_categoria);
END;
//
DELIMITER ;

-- Modificar categoría
DELIMITER //
CREATE PROCEDURE SP_ModificarCategoria(
    IN v_id_categoria INT,
    IN v_nombre_categoria VARCHAR(100),
    IN v_descripcion_categoria VARCHAR(100),
    IN v_estado_categoria VARCHAR(11)
)
BEGIN
    UPDATE tb_categoria
    SET nombre = v_nombre_categoria,
        descripcion = v_descripcion_categoria,
        estado = v_estado_categoria
    WHERE ID_categoria = v_id_categoria;
END;
//
DELIMITER ;

-- Eliminar (inactivar) categoría
DELIMITER //
CREATE PROCEDURE SP_EliminarCategoria(
    IN v_id_categoria INT
)
BEGIN
    UPDATE tb_categoria
    SET estado = 'Inactivo'
    WHERE ID_categoria = v_id_categoria;
END;
//
DELIMITER ;

-- Insertar producto
DELIMITER //
CREATE PROCEDURE SP_InsertarProducto(
    IN v_id_producto VARCHAR(50),
    IN v_nombre_producto VARCHAR(100),
    IN v_descripcion_producto VARCHAR(100),
    IN v_precio DECIMAL(10,2),
    IN v_cantidad INT,
    IN v_id_categoria INT,
    IN v_estado_producto VARCHAR(11)
)
BEGIN
    INSERT INTO tb_producto(ID_Producto, nombre, descripcion, precio_venta, cantidad, ID_categoria, estado)
    VALUES(v_id_producto, v_nombre_producto, v_descripcion_producto, v_precio, v_cantidad, v_id_categoria, v_estado_producto);
END;
//
DELIMITER ;

-- Modificar producto
DELIMITER //
CREATE PROCEDURE SP_ModificarProducto(
    IN v_id_producto VARCHAR(50),
    IN v_nombre_producto VARCHAR(100),
    IN v_descripcion_producto VARCHAR(100),
    IN v_precio DECIMAL(10,2),
    IN v_cantidad INT,
    IN v_id_categoria INT,
    IN v_estado_producto VARCHAR(11)
)
BEGIN
    UPDATE tb_producto
    SET nombre = v_nombre_producto,
        descripcion = v_descripcion_producto,
        precio_venta = v_precio,
        cantidad = v_cantidad,
        ID_categoria = v_id_categoria,
        estado = v_estado_producto
    WHERE ID_Producto = v_id_producto;
END;
//
DELIMITER ;

-- Eliminar (inactivar) producto
DELIMITER //
CREATE PROCEDURE SP_EliminarProducto(
    IN v_id_producto VARCHAR(50)
)
BEGIN
    UPDATE tb_producto
    SET estado = 'Inactivo'
    WHERE ID_Producto = v_id_producto;
END;
//
DELIMITER ;

-- Insertar cliente
DELIMITER //
CREATE PROCEDURE SP_InsertarCliente(
    IN v_identidad VARCHAR(15),
    IN v_nombre_cliente VARCHAR(100),
    IN v_telefono VARCHAR(50),
    IN v_direccion VARCHAR(100),
    IN v_estado_cliente VARCHAR(11)
)
BEGIN
    INSERT INTO tb_cliente(identidad, nombre, telefono, direccion, estado)
    VALUES(v_identidad, v_nombre_cliente, v_telefono, v_direccion, v_estado_cliente);
END;
//
DELIMITER ;

-- Modificar cliente
DELIMITER //
CREATE PROCEDURE SP_ModificarCliente(
    IN v_identidad VARCHAR(15),
    IN v_nombre_cliente VARCHAR(100),
    IN v_telefono VARCHAR(50),
    IN v_direccion VARCHAR(100),
    IN v_estado_cliente VARCHAR(11)
)
BEGIN
    UPDATE tb_cliente
    SET nombre = v_nombre_cliente,
        telefono = v_telefono,
        direccion = v_direccion,
        estado = v_estado_cliente
    WHERE identidad = v_identidad;
END;
//
DELIMITER ;

-- Eliminar (inactivar) cliente
DELIMITER //
CREATE PROCEDURE SP_EliminarCliente(
    IN v_identidad VARCHAR(15)
)
BEGIN
    UPDATE tb_cliente
    SET estado = 'Inactivo'
    WHERE identidad = v_identidad;
END;
//
DELIMITER ;

