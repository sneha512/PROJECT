import { useState } from 'react'
import './App.css'

export default function temperature()
{
  const [temp,setTemp]=useState(10);
  const [tempColor,setTempColor]=useState('cold');
  function handleclicki(){
    const newTemp=temp+1;
    setTemp(newTemp);
    if(newTemp>=15){
      setTempColor('hot');
    }
  }
  function handleclickd(){
    const newTemp=temp-1;
    setTemp(newTemp);
    if(newTemp<15){
      setTempColor('cold');
    }
  }

return (
  <div className='app-container'>
    <div className='temperature-display-container'>
      <div className={`temperature-display ${tempColor}`}>{temp}°C</div>
    </div>
    <div className='button-container'>
    <button onClick={handleclicki}>+</button>
    <button onClick={handleclickd}>-</button>
    {/* <p>temperature:{temp}</p> */}
  </div>
  </div>
);
}
function App()
{
  return(
    <>
    <temperature/>
    </>
  );
}