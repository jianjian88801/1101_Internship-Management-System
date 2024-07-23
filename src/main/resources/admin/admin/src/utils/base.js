const base = {
    get() {
        return {
            url : "http://localhost:8080/shixiguanlixitong/",
            name: "shixiguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shixiguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "实习管理系统"
        } 
    }
}
export default base
