package com.qiushui.blurredviewdemo

import android.app.Activity
import android.view.View
import android.widget.TextView
import java.util.*
import kotlin.collections.HashMap

/**
 * kotlin基础
 * @author lifei
 */
class SecondActivity : Activity() {

    /**
     * 0.修饰符,范围从大到小
     */
    //public
    //internal 相同模块可见 一般是同一个项目
    //protected
    //private

    /**
     * 单例Company对象
     * object表示单例
     */
    object Company {
        const val name: String = "Keep"//对象常量

    }

    /**
     * companion object 表示静态的
     *
     */
    companion object Book {
        var book: String = "book"
        val page: Int = 100
    }

    /**
     *1，变量
     *  1.1 初始化赋值，防止出现空指针
     *  1.2 初始化延迟加载
     *  1.3 初始化为null,后期通过判断null来创建对像
     */
    var text: String = "Hello"//定义变量,立即赋值
    val textFinal: String = "Hello"//定义final常量
    var b = 2//自动推断Int类型
    var c: Double = 2.5
    var d: String = ""
    var ob: Any? = null //?表示当前对象可以是null,不加的话变量不可为null，为null则编译不通过
    var textView: TextView? = null//
    var list: List<String>? = null
    var list2: List<String> = ArrayList<String>()
    val hashMap: HashMap<Int, String> = hashMapOf()
    lateinit var age: String //延迟初始化，只能修饰var 不能修饰val,只能做成员变量
    val lazy: String by lazy {
        "测试"
    }

    //声明接口变量
    private val callback: ICallBack = object : ICallBack {
        override fun success(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun fail(string: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    //by lazy{} val 的延迟初始化
    //internal  修饰的变量或者类是模块内可见的
    //inner   内部类
    inner class InnerActivity {}

    init {
        println("静态代码块")
    }


    /**
     *
     * 2，函数
     * 快捷键 void  定义无返回值的函数，fun0定义无参数的函数，fun1定义包含一个参数的函数，fun2定义包含两个参数函数
     * inline 定义内联函数
     */
    inline fun sum(a: Int, b: Int): Int {//有返回值
        return a + b
    }

    fun sum2(a: String, b: String) = a + b//有返回值

    fun sum2(a: Int) = 5//有返回值自动推断

    fun sum3(): Unit {}//无返回值

    fun sum4() {}//无返回值，省略Unit形式

    fun sum5(a: Int) = if (a > 5) "1" else "2" //无返回值

    fun main(args: Array<String>) {
        print(sum(1, 2))
        var cantNull: String? = null//可以为null
        print(cantNull.toString())//普通调用
        print(cantNull!!.toString())//空检查，不为空才执行后面的

        //强制转换 在后面
        textView = View(null) as TextView
        //两种方式
        textView!!.setText("!!表示不为空才执行,如果为null会抛出空指针异常")
        textView?.setText("? 表示不为空才执行，如果为null会返回null")

        textView!!.text = "第三种表现形式"

        "搜索".toast("使用了扩展函数")

    }

    // 扩展函数,在不改变String类源码情况下，为其添加了toast()方法
    fun String.toast(text: String) {
        println(text)
    }

    /**
     * 3.条件控制语句
     */
    fun control() {

        //object
        var a: Any? = null
        var b: Any? = null
        a = 3L
        b = 5L
        //if
        if (a is Long) {
            print("a is Long")
        } else if (a is Int) {
            print("a is Int")
        } else {
            print("a is other")
        }

        //switch
        when (a) {
            is Int -> println("a is Int")// is =
            is Long -> println("a is Long")
            is Double -> println("a is Double")
            else -> println("a is other")
        }
        a = 2
        //switch ..范围
        when (a) {
            in 1..3 -> println("闭区间 1-3")
            in 2 until 4 -> println("半开区间不包含4 2-4")
            in 2..10 step 2 -> println("步长2")
            else -> println("a >4")
        }

        //等价三目运算符

        var max = if (a > b) a else b //if 有返回值
        // ?: 操作符 ，如果左侧表示非空 就返回左侧表达式， 否则返回右侧表达式

        /**
         * 作用域函数
         * also 函数内可以通过it指代该对象，返回值为该对象自己
         * apply 函数内可以通过this指代该对象，返回值为该对象自己
         *
         * let 函数内it指代该对象，返回值为函数最后一行或者指定return表达式
         * run 函数内可以通过this指代该对象，返回值为函数最后一行或者指定return表达式
         */
        var pushId: String? = null
        println(pushId?.length ?: "empty")
        //let操作符
        max?.let { println("max不为null时候会执行") }

        //run 有一个返回值返回函数最后一行或者指定return表达式
        var animal = "cat"
        run {
            val animal = "dog"
            println(animal)//dog
        }
        //函数内this可以指代该对象
        var animal2 = "big".run {
            println(this)//big
            3
            4
        }
        println(animal)//cat

        //apply操作符


    }

    /**
     * 4.集合相关
     */
    fun listAndMap() {

        var emptyList = emptyList<String>() //创建空的list
        val readList = listOf<Int>(1, 2, 3) //
        val mList = mutableListOf<Int>(1, 2, 3)//创建可变的list


        val emptyMap = emptyMap<Int, String>()
        val readMap = mapOf<Int, String>(1 to "1", 2 to "2")
        val mMap = mutableMapOf<Int, String>(1 to "1", 2 to "2")


        //list
        list = ArrayList<String>()

        var list3 = listOf<String>("a", "b", "c")

        //过滤filer
        (list as ArrayList<String>).filter { it.equals("eee") }


        //map
        var map: Map<Int, String>? = null
        map = HashMap<Int, String>()

        var map3 = mapOf<String, String>("1" to "a", "2" to "b")
        println(map3["key"])//访问map某个key对应的值

        //遍历map
        for ((k, v) in map) {
            println("$k -> $v")
        }

        map3?.let {
            it.forEach { key, value ->
                println("key is $key")
                println("value is $value")
            }
        }
        //_传入参数 key没有用到，用_代替
        map.forEach { _, value ->
            println("value is $value")
        }

        //遍历1-100
        for (i in 0..99) {
            println(i)
        }

        //增强for遍历
        (list as ArrayList<String>).forEach { println(it) }

    }


    /**
     * 定义类
     */
    class OriginActivity {}

    open class TestActivity {}
    /**
     * 继承:  实现，
     */
    class Test2Activity : TestActivity(), ICallBack {
        override fun fail(string: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun success(): Boolean {
            print("success")
            return true
        }
    }

    /**
     * 定义接口
     */
    interface ICallBack {
        fun success(): Boolean
        fun fail(string: String)
    }

    /**
     * 字符串模版4种方式
     * 1 ${变量}
     * 2 $变量  有时候不行
     * 3 ${方法()}
     * 4 ${表达式}
     */
    fun stringStyle() {
        var a = 1
        var b = "a is $a"//a is 1
        var c = "a is ${sum(1, 2)}"
    }
    //@  限定符 this@SecondActivity ,限定this的类型

}