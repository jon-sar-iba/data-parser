import React, { useState, useRef, useEffect } from 'react';
import '../hoja-de-estilos/ConsultarProducto.css';

function ConsultarProducto() {
  const [radioSeleccionado, setRadioSeleccionado] = useState('todos'); // Estado para almacenar el tipo de consulta seleccionado
  const [clave, setClave] = useState(''); // Estado para almacenar la clave ingresada
  const [datosConsultados, setDatosConsultados] = useState([]); // Estado para almacenar los datos consultados
  const [error, setError] = useState(null); // Estado para almacenar el error
  const inputClaveRef = useRef(null); // Referencia al input de texto

  const consultaTypeChange = (event) => {
    setRadioSeleccionado(event.target.value); // Actualizar el estado con el valor del radio button seleccionado
  };

  const handleConsultarClick = () => {
    if (radioSeleccionado === 'todos') {
      // Realizar la petición al backend para consultar todos los productos
      fetch('http://localhost:8080/api/listarProductos')
        .then(data => {
          // Verificar si la respuesta es un array o un objeto
          if (Array.isArray(data)) {
            setDatosConsultados(data); // Almacenar los datos consultados en el estado
          } else {
            // Si la respuesta es un objeto, convertirlo a un array de un solo elemento
            setDatosConsultados([data]);
          }
          setError(null); // Reiniciar el estado de error
        })
        .then(data => {
          setDatosConsultados(data); // Almacenar los datos consultados en el estado
          setError(null); // Reiniciar el estado de error
        })
        .catch(error => {
          setError(error.message); // Almacenar el mensaje de error
        });
    } else if (radioSeleccionado === 'byKey') {
      // Verificar que se haya ingresado una clave
      if (!clave) {
        setError('Por favor ingrese una clave.');
        return;
      }

      // Construir el objeto JSON con la clave
      const id = parseInt(clave);
      console.log(typeof id);
      if (isNaN(id)) {
        // La clave no es un número
        alert('Por favor ingrese un valor numérico para la clave.');
        return;
      }
      console.log('id= ',id);
      // Realizar la petición al backend para consultar por clave
      console.log('Antes de fetch');
      fetch(`http://localhost:8080/api/buscarProducto/${id}`)
        .then(response => {
          if (!response.ok) {
            alert('Error al consultar los datos.');
          }
          return response.json();
        })
        .then(data => {
          setDatosConsultados(data);
          setError(null);
        })
        .catch(error => {
          alert('Error en FETCH:', error.message);
      });
    }
  };

  useEffect(() => {
    if (radioSeleccionado === 'byKey' && inputClaveRef.current) {
      inputClaveRef.current.focus(); // Enfocar el input de texto
    }
  }, [radioSeleccionado]);

  return (
    <div className='consulta-producto-principal'>
      <h2>Producto</h2>
      <div>
        <div className='contenedor-izquierdo'>
          <div className='contenedor-ingresa-datos'>
            <h2>Consultar:</h2>
            <div className='opciones-de-consulta'>
              <div>
                <input type="radio" name="consultaType" value="todos" id="radTodos" checked={radioSeleccionado === 'todos'} onChange={consultaTypeChange} />
                <label htmlFor="radTodos">Todos</label>
              </div>
              <div>
                <input type="radio" name="consultaType" value="byKey" id="radPorClave" checked={radioSeleccionado === 'byKey'} onChange={consultaTypeChange} />
                <label htmlFor="radPorClave">Por Clave:</label>
              </div>
            </div>
            <div className='contenedor-caja-por-clave'>
              {radioSeleccionado === 'byKey' && <input className='caja-text-por-clave' type="text" ref={inputClaveRef} placeholder="Ingrese la clave" value={clave} onChange={(e) => setClave(e.target.value)} />}
            </div>
            <div>
              <button id="btnConsultarProductos" className="boton-consultar" type="button" onClick={handleConsultarClick}>Consultar</button>
            </div>
            {error && <p>{error}</p>}
            {error && alert('Algo salió mal: ' + error)}
          </div>
        </div>
        <div className='contenedor-muestra-datos'>
          <div className='contenedor-datos'>
            {datosConsultados.map((dato, index) => (
              <div key={index}>
              <div className='estructura-de-datos'>
                <p>Clave: {dato.intIdProducto} </p>
                <p>Nombre: {dato.cvNombre} </p>
                <p>Precio: {dato.decPrecioUnitario} </p>
                <p>Antiguedad por mes: {dato.intAntiguedadXMes}</p>
              </div>
            </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default ConsultarProducto;
