const login = async () => {

}

const logout = async () => {
    console.log('logout')

    try {
        const indexRes = await fetch('/auth/logout', {
            method: 'POST'
        })

        if (!indexRes.ok) {
            console.error('auth > logout > indexRes: ', indexRes)
            return
        }

        const indexResText = await indexRes.text()

        console.log('auth > logout > indexResText: ', indexResText)
        document.getElementById('content-container').innerHTML = indexResText

        const headerRes = await fetch('header')
        const headerResText = await headerRes.text()
        const headerEl = document.getElementById('header');
        headerEl.outerHTML = headerResText;
        initListeners('index')
    } catch (err) {
        console.error('auth > logout > logout error: ', err)
    }
}