filterRewardConvertHistoryList = async (affiliateId, currPage, pageSize) => {
    const params = new URLSearchParams({
        currPage: currPage,
        pageSize: pageSize
    })
    const res = await fetch(`affiliates/rewards/histories/affiliate/${affiliateId}?${params.toString()}`)
    const el = document.getElementById('affiliate-reward-convert-history-list-container')
    el.outerHTML = await res.text()
}