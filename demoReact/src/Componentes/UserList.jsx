import React, { useEffect, useState } from "react";
import axios from "axios";

const UserList = () => {
    const [users, setUsers] = useState([]);
    useEffect(() => {
        axios.get("http://localhost:8080/users", {
            headers: {
                'Content-Type': 'application/json'
            },
            withCredentials: true  // Si estás usando cookies o sesiones
        })  // Asegúrate de usar la URL completa
            .then(response => {
                setUsers(response.data);
            })
            .catch(error => {
                console.error("Error fetching users:", error);
            });
    }, []);

    return (
        <div>
            <h1>Lista de Usuarios</h1>
            <ul>
                {users.map(user => (
                    <li key={user.id}>
                        <b color="">Nombre:</b>{user.name}  <b color="">Email:</b>{user.email}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default UserList;
