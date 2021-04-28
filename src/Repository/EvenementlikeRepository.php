<?php

namespace App\Repository;

use App\Entity\Evenementlike;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Evenementlike|null find($id, $lockMode = null, $lockVersion = null)
 * @method Evenementlike|null findOneBy(array $criteria, array $orderBy = null)
 * @method Evenementlike[]    findAll()
 * @method Evenementlike[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class EvenementlikeRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Evenementlike::class);
    }

    // /**
    //  * @return Evenementlike[] Returns an array of Evenementlike objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('e')
            ->andWhere('e.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('e.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Evenementlike
    {
        return $this->createQueryBuilder('e')
            ->andWhere('e.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
