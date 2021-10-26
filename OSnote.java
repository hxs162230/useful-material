CPU scheduling
1.FCFS - waiting time too long
2.SJF
3.搶佔式SJF = shortest remain time first serve
4.priority scheduling - starvation -> aging techinque reset priority
5.RR(time slicing) - if process takes a lot of time -> FCFS
6.Multilevel queue
	ex RR + FCFS
7.Multilevel feedback queue
	interactions btw queue

multi processor
	ASMP
	SMP
		soft affinity 
		hard affinity : LINUX

线程调度
系统调度的是内核线程，而不是进程。用户线程由线程库管理，内核并不了解它们。
用户线程最终必须映射到相应的内核级线程,尽管这种映射可能是间接的，可能使用轻量级进程（LWP）。
PCS 線程庫調度
SCS 系統内核調度
用户线程和内核线程的区别之一是它们是如何被调度的。在执行多对一模型和多对多模型系统上，
线程库调度用户级线程到一个有效的LWP上运行，
这被称为进程竞争范围（process-contention scope，PCS）方法，
因为CPU竞争发生在属于相同进程的线程之间。为了决定调度哪个内核线程到CPU，
内核采用系统竞争范围（system-contention scope，SCS）方法来进行，
竞争CPU发生在系统所有线程中，采用一对一的模型的系统，调度仅使用SCS方法。
####################################################################################

進程同步:

多个进程并发访问和操作同一数据且执行结果与访问发生的特定顺序有关，
称之为竞争条件（race condition）。
Semaphore 应用层面解决临界区问题：信号量
classic problem 
producer-consumer problem
reader-writer problem
	writer preemtive -  reader starvation
	writer non-preemptive - writer starvation
philoshopher problem
Moniter 基本的、高级的同步构造，即管程（monitor）类型。

#####################################################################################
deadlock 
1.mutual exclusion
2.non preemtive
3.occupancy - 申請過多資源 (sol: free and re-apply => starvation+utilization rate low)
4.waiting loop (depend on) p1->p2->p3->p1 (sol:如果需要同一资源类型的多个实例，那么对它们必须一起申请。)


死锁预防（deadlock prevention）是一组方法，以确保至少一个必要条件不成立。
这些方法通过限制如何申请资源的方法来预防死锁。

死锁避免（deadlock avoidance）要求操作系统事先得到有关进程申请资源和使用资源的
额外信息。有了这些额外信息，系统可以确定：对于一个申请，进程是否应等待。
为了确定当前申请是允许还是延迟，系统必须考虑可用资源，已经分配给每个进程的资源，
每个进程将来申请和释放的资源。

除此之外，系统还可以提供一个算法来检查系统状态来确定死锁是否发生，
并提供另一个算法来从死锁中恢复。
预防死锁的副作用是降低设备的使用率和系统的吞吐率。