/* ══════════════════════════════════════════════════════
   main.js — JS global cargado en todas las páginas
   a través del layout base.html

   Agrega aquí lógica que aplique a toda la app:
   - Menú hamburguesa responsive
   - Resaltado de nav link activo
   - Utilidades compartidas
══════════════════════════════════════════════════════ */

document.addEventListener('DOMContentLoaded', () => {

    /* ── Menú hamburguesa (responsive) ── */
    const hamburger = document.querySelector('.nav-hamburger');
    const navLinks  = document.querySelector('.nav-links');

    if (hamburger && navLinks) {
        hamburger.addEventListener('click', () => {
            navLinks.classList.toggle('open');
        });
    }

    /* ── Cerrar menú al hacer click en un link ── */
    document.querySelectorAll('.nav-links a').forEach(link => {
        link.addEventListener('click', () => {
            navLinks?.classList.remove('open');
        });
    });

});