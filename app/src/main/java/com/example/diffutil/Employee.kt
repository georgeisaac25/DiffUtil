package com.example.diffutil


class Employee(var id: Int, var name: String?, var role: String) {

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null || javaClass != obj.javaClass) return false
        val employee = obj as Employee
        if (id != employee.id) return false
        if (!role.equals(employee.role, ignoreCase = true)) return false
        return if (name != null) name == employee.name else employee.name == null
    }

    override fun hashCode(): Int {
        var result = id
        result += if (name != null) name.hashCode() else 0
        result += role.hashCode()
        return result
    }

}