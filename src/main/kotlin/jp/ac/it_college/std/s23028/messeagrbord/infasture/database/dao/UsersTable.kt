package jp.ac.it_college.std.s23028.messeagrbord.infasture.database.dao


import org.jetbrains.exposed.dao.id.LongIdTable

object UsersTable : LongIdTable("user") {
    val viewName = varchar("view_name", 32)
    val email = varchar("email", 256).uniqueIndex()
    val password = varchar("password", 128)
}
