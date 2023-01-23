const actionFormAddEl = document.getElementById('actionForm')

const dateActionAddInputEl = actionFormAddEl.querySelector('input[name="date"]');
const fromActionAddInputEl = actionFormAddEl.querySelector('input[name="time_from"]');
const toActionAddInputEl = actionFormAddEl.querySelector('input[name="time_to"]');
const patientIdActionAddInputEl = actionFormAddEl.querySelector('input[name="patient_id"]');
const doctorIdActionAddInputEl = actionFormAddEl.querySelector('input[name="doctor_id"]');

const createFormEl = document.getElementById('createForm');

const dateInputEl = createFormEl.querySelector('input[id="date"]');
const fromInputEl = createFormEl.querySelector('input[id="time_from"]');
const toInputEl = createFormEl.querySelector('input[id="time_to"]');
const patientIdInputEl = createFormEl.querySelector('input[id="patient_id"]');
const doctorIdInputEl = createFormEl.querySelector('input[id="doctor_id"]');

function dataToAction(){
    dateActionAddInputEl.value = dateInputEl.value
    fromActionAddInputEl.value = fromInputEl.value
    toActionAddInputEl.value = toInputEl.value
    patientIdActionAddInputEl.value = patientIdInputEl.value
    doctorIdActionAddInputEl.value = doctorIdInputEl.value
}
