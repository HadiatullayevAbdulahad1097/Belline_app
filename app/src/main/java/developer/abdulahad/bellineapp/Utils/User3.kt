package developer.abdulahad.bellineapp.Utils

class User3 {
    var name : String = ""
    var narh : String = ""
    var daqiqa : String = ""
    var sms : String = ""
    var muddat : String = ""
    var raqam: String = ""

    constructor(name: String, raqam: String, narh: String, daqiqa: String, sms: String, muddat: String) {
        this.name = name
        this.narh = narh
        this.daqiqa = daqiqa
        this.sms = sms
        this.muddat = muddat
        this.raqam = raqam
    }

    constructor(name: String, raqam: String, narh: String, daqiqa: String, muddat: String) {
        this.name = name
        this.narh = narh
        this.daqiqa = daqiqa
        this.muddat = muddat
        this.raqam = raqam
    }

    constructor(name: String, raqam: String, narh: String, muddat:String) {
        this.name = name
        this.narh = narh
        this.muddat = muddat
        this.raqam = raqam
    }
}