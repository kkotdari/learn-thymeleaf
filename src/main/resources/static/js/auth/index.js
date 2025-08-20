signup = async () => {
    const form = document.getElementById('signup-form');
    const formData = new FormData(form)

    fetch('auth/signup', {
        method: 'POST',
        body: formData
    })
        .then(res => {
            if (!res.ok) {
                throw new Error('Signup failed')
            }
            return res.text()
        })
        .then(html => {
            document.getElementById('content-container').innerHTML = html
        })
        .catch(err => {
            console.error('auth > signup > signup error: ', err)
        })
}

login = async () => {
    const form = document.getElementById('login-form')
    const formData = new FormData(form)

    try {
        const indexRes = await fetch('/auth/login', {
            method: 'POST',
            body: formData
        })

        if (!indexRes.ok) {
            console.error('auth > login > indexRes: ', indexRes)
        }

        const indexResText = await indexRes.text()

        console.log('auth > login > indexResText: ', indexResText)
        document.getElementById('content-container').innerHTML = indexResText

        const headerRes = await fetch('header')
        const headerResText = await headerRes.text()
        const headerEl = document.getElementById('header');
        headerEl.outerHTML = headerResText;
    } catch (err) {
        console.error('auth > login > login error: ', err)
    }
}

logout = async () => {
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
    } catch (err) {
        console.error('auth > logout > logout error: ', err)
    }
}