package ru.maksim.cellidentityinfo.bd

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import ru.maksim.cellidentityinfo.model.Users

object User : IntIdTable("Users") {
        val idlocation: Column<Int> = integer("idlocation").uniqueIndex().references(Location.idlocation)
        val number: Column<String> = varchar("number", 15)
        val email: Column<String> = varchar("email", 45)
        val name: Column<String> = varchar("name", 15)
        val lastName: Column<String> = varchar("lastName", 15)

}

class UsersEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UsersEntity>(User)

    var idlocation by User.idlocation
    var number by User.number
    var email by User.email
    var name by User.name
    var lastName by User.lastName

    fun toUsers() = Users(id.value, name, lastName, email, number)
}

object Location : Table("Location") {
    val idlocation: Column<Int> = integer("idlocation").autoIncrement().uniqueIndex()
    val latitude: Column<Int> = integer("latitude")
    val longtitude: Column<Int> = integer("longtitude")
    val time: Column<String> = varchar("time", 10)

    override val primaryKey = PrimaryKey(idlocation, name = "Loc_Us_idloc")
}

object BaseStation : Table("BaseStation") {
    val idparameters: Column<Int> = integer("idparsmeters").uniqueIndex().autoIncrement()
    val idlocation: Column<Int> = integer("idlocation").uniqueIndex().references(Location.idlocation)
    val mcc_mnc: Column<String> = varchar("mcc_mnc", 20)
    val lac: Column<Int> = integer("lac")
    val cid: Column<Int> = integer("cid")
    val bsic_psc_pci: Column<Int> = integer("bsic_psc_pci")
    val asuLevel: Column<Int> = integer("asuLevel")
    val signalLevel: Column<Int> = integer("signalLevel")
    val dbm: Column<Int> = integer("dbm")
    val type: Column<String> = varchar("type", 10)

    override val primaryKey = PrimaryKey(idparameters)
}
fun db() {
    Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver")
}

object Books : IntIdTable() {
    val title = varchar("title", 255)
    val author = varchar("author", 255)
}

class BookEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BookEntity>(Books)

    var title by Books.title
    var author by Books.author

    override fun toString(): String = "Book($title, $author)"

    fun toBook() = Book(id.value, title, author)
}

data class Book(
    val id: Int,
    val title: String,
    val author: String
)