import React, {useState} from 'react';
import '../hoja-de-estilos/BarraNav.css';
import ConsultarProducto from './ConsultarProducto';
import Inicio from './Inicio';

function BarraNav() {

  const [consultarProductoVisible, setConsultarProductoVisible] = useState(false);
  const [inicioCargaArchivoVisible, setInicioCargaArchivoVisible] = useState(true);

  //Al seleccionar una opcion del menú de la barra de navegacion se deshabilita la sección de inicio
  const handleConsultarProductoClick = () => {
    setConsultarProductoVisible(!consultarProductoVisible);
    setInicioCargaArchivoVisible(false);
  };
  //Cargar sección de inicio y deshabilitar todas las otras secciones a excepcion de la barra de navegacion
  const handleInicioClick = () => {
    setInicioCargaArchivoVisible(true);
    setConsultarProductoVisible(false);
  };

  return (
    <div className='barra-nav-body'>
      <div className='contenedor-nav'>
        <nav>
        <ul className='menu-inicio'>
            <li><a href='#' onClick={handleInicioClick}>Inicio</a></li>
          </ul>
          <ul className='menu-opciones'>
            <li>
              <a href='#'>Registrar</a>
              <ul>
                <li><a href='#'>Producto</a></li>
                <li><a href='#'>Estado</a></li>
                <li><a href='#'>Método/Pago</a></li>
                <li><a href='#'>Estatus</a></li>
              </ul>
            </li>
            <li>
              <a href='#' onClick={handleConsultarProductoClick}>Consultar</a>
              <ul>
                <li><a href='#'>Factura</a></li>
                <li><a href='#' onClick={handleConsultarProductoClick}>Producto</a></li>
                <li><a href='#'>Estado</a></li>
                <li><a href='#'>Método/Pago</a></li>
                <li><a href='#'>Bitácora</a></li>
                <li><a href='#'>Estatus</a></li>
              </ul>
            </li>
            <li>
              <a href='#'>Actualizar</a>
              <ul>
                <li><a href='#'>Producto</a></li>
                <li><a href='#'>Estado</a></li>
                <li><a href='#'>Método/Pago</a></li>
                <li><a href='#'>Estatus</a></li>
              </ul>
            </li>
            <li>
              <a href='#'>Eliminar</a>
              <ul>
                <li><a href='#'>Producto</a></li>
                <li><a href='#'>Estado</a></li>
                <li><a href='#'>Método/Pago</a></li>
                <li><a href='#'>Estatus</a></li>
              </ul>
            </li>
          </ul>
        </nav>
      </div>
      {inicioCargaArchivoVisible && (
        <div id='inicioCargaArchivo' className='inicio'>
          <Inicio />
        </div>
      )}
      {consultarProductoVisible && (
        <div className='consultar-producto'>
          <ConsultarProducto />
        </div>
      )}
    </div>
  );
}

export default BarraNav;
