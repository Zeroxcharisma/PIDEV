<?php

namespace App\Repository;

use App\Data\FiltreData;
use App\Entity\Testfitness;
use App\Entity\Cours;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Testfitness|null find($id, $lockMode = null, $lockVersion = null)
 * @method Testfitness|null findOneBy(array $criteria, array $orderBy = null)
 * @method Testfitness[]    findAll()
 * @method Testfitness[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class TestfitnessRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Testfitness::class);
    }

    // /**
    //  * @return Testfitness[] Returns an array of Testfitness objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('t')
            ->andWhere('t.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('t.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Testfitness
    {
        return $this->createQueryBuilder('t')
            ->andWhere('t.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */

    public function findByFiltre(FiltreData $filtreData)
    {
        $query = $this
            ->createQueryBuilder('test');

        if(!empty($filtreData->courT)){
            $query = $query
                ->andWhere('test.cours = :courT')
                ->setParameter('courT', $filtreData->courT);

        }
        if(!empty($filtreData->min)){
            $query = $query
                ->andWhere('test.duree >= :min')
                ->setParameter('min', $filtreData->min);
        }
        if(!empty($filtreData->max)){
            $query = $query
                ->andWhere('test.duree <= :max')
                ->setParameter('max', $filtreData->max);
        }

        return
            $query->getQuery()->getResult();
    }


    /*
 * nombre des portfolio par date
 */
    public function CountByDate(){
        $query = $this->getEntityManager()->createQuery("
        SELECT SUBSTRING(t.dateTest, 1, 10) as dateTest, COUNT(t) as count FROM
        App\Entity\Testfitness t GROUP BY dateTest");
        return $query->getResult();
    }
}
