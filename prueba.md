Agendar Cita:

curl -s -X POST http://localhost:8080/api/citas \
  -H "Content-Type: application/json" \
  -d '{
    "pacienteId": "11111111-1111-1111-1111-111111111111",
    "doctorId": "22222222-2222-2222-2222-222222222222",
    "especialidadId": "33333333-3333-3333-3333-333333333333",
    "fechaHora": "2026-06-15T10:00:00"
  }'


Confirmar:

curl -s -X PUT http://localhost:8080/api/citas/{id}/confirmar

Reagendar:

curl -s -X PUT http://localhost:8080/api/citas/{id}/reagendar \
  -H "Content-Type: application/json" \
  -d '"2026-07-20T15:30:00"'

Cancelar:

curl -s -X PUT http://localhost:8080/api/citas/{id}/cancelar