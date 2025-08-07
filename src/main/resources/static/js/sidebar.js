toggleSidebar = () => {
    console.log('toggleSidebar: called')
    const sidebarToggleAdaptiveEls = document.getElementsByClassName('sidebar-toggle-adaptive');
    Array.from(sidebarToggleAdaptiveEls)
        .forEach(e => {
            e.classList.toggle('with-sidebar-off')
        })

    const sidebarToggleBtnEl = document.getElementById('sidebar-toggle-btn')
    console.log('sidebar-toggle-btn', sidebarToggleBtnEl)
    if (sidebarToggleBtnEl.classList.contains('with-sidebar-off')) {
        sidebarToggleBtnEl.innerText = '>'
    } else {
        sidebarToggleBtnEl.innerText = '<'
    }
}