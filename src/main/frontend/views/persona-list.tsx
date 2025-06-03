import { useEffect, useState } from 'react';

export default function PersonaList() {
  const [personas, setPersonas] = useState([]);

  useEffect(() => {
    fetch('/api/personas')
      .then(res => res.json())
      .then(setPersonas);
  }, []);

  return (
    <div>
      <h2>Personas</h2>
      <ul>
        {personas.map((p: any) => (
          <li key={p.id}>{p.nombres} {p.apellidos} - {p.email}</li>
        ))}
      </ul>
    </div>
  );
}