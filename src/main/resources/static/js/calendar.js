/* ══════════════════════════════════════════════════════
   calendar.js — Solo se carga en páginas que usen el
   componente de calendario (ej: home.html / agenda)
══════════════════════════════════════════════════════ */

const MONTHS = [
    'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
    'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'
];

const DAY_NAMES = ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'];

let currentDate = new Date();
let selectedDate = null;

function renderCalendar() {
    const titleEl = document.getElementById('calTitle');
    const gridEl  = document.getElementById('calGrid');
    if (!titleEl || !gridEl) return;

    titleEl.textContent = `${MONTHS[currentDate.getMonth()]} ${currentDate.getFullYear()}`;

    const firstWeekday = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1).getDay();
    const daysInMonth  = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0).getDate();
    const today        = new Date();

    let html = DAY_NAMES.map(d => `<div class="cal-day-name">${d}</div>`).join('');

    for (let i = 0; i < firstWeekday; i++) {
        html += `<div class="cal-day empty"></div>`;
    }

    for (let day = 1; day <= daysInMonth; day++) {
        const isToday =
            day === today.getDate() &&
            currentDate.getMonth() === today.getMonth() &&
            currentDate.getFullYear() === today.getFullYear();

        const isSelected =
            selectedDate &&
            day === selectedDate.getDate() &&
            currentDate.getMonth() === selectedDate.getMonth() &&
            currentDate.getFullYear() === selectedDate.getFullYear();

        const cls = isToday ? 'today' : isSelected ? 'selected' : '';
        html += `<div class="cal-day ${cls}" onclick="selectDay(${day})">${day}</div>`;
    }

    gridEl.innerHTML = html;
}

function selectDay(day) {
    selectedDate = new Date(currentDate.getFullYear(), currentDate.getMonth(), day);
    renderCalendar();
}

document.getElementById('prevMonth')?.addEventListener('click', () => {
    currentDate.setMonth(currentDate.getMonth() - 1);
    renderCalendar();
});

document.getElementById('nextMonth')?.addEventListener('click', () => {
    currentDate.setMonth(currentDate.getMonth() + 1);
    renderCalendar();
});

renderCalendar();