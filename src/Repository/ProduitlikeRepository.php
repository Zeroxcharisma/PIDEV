<?php

namespace App\Repository;

use App\Entity\Produitlike;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Produitlike|null find($id, $lockMode = null, $lockVersion = null)
 * @method Produitlike|null findOneBy(array $criteria, array $orderBy = null)
 * @method Produitlike[]    findAll()
 * @method Produitlike[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ProduitlikeRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Produitlike::class);
    }

    // /**
    //  * @return Produitlike[] Returns an array of Produitlike objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('p.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Produitlike
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
